const fs = require("fs");
const https = require("https");
const bcrypt = require("bcrypt");
const express = require("express");
const mariaDB = require("mysql2/promise");

require('dotenv').config();

const app = express();
app.use(express.json());

const cors = require("cors");
app.use(cors());

//https 인증서 위치
const options = {
    key : fs.readFileSync(process.env.HTTPS_KEY),
    cert : fs.readFileSync(process.env.HTTPS_CERT),
    ca : fs.readFileSync(process.env.HTTPS_CA),
};

const db = mariaDB.createPool({
    host : process.env.DB_HOST,
    port : process.env.DB_PORT,
    user : process.env.DB_USER,
    password : process.env.DB_PASSWORD,
    database : process.env.DB_SCHEMA
});

app.post("/login", async (req, res) => {
    const { userId, password } = req.body;

    try {
        const [rows] = await db.query("SELECT * FROM BOOK_LOGIN WHERE ID = ?", [userId]);
        if(rows.length === 0) {
            console.log("사용자를 찾지못했습니다.");
            return res.status(404).json({success : false, message : "사용자를 찾을 수 없습니다."});
        }

        const user = rows[0];

        if(user.FAIL_COUNT >= 5) {
            console.log("비밀번호 5회 초과");
            return res.status(401).json({success : false, message : "비밀번호를 5회 이상 틀리셨습니다.\n 비밀번호 변경 후 이용해주시길 바랍니다."});
        }

        const isPasswordValid = await bcrypt.compare(password, user.PASSWORD);

        if(!isPasswordValid) {
            console.log("패스워드 오류");
            await db.query("UPDATE BOOK_LOGIN SET FAIL_COUNT = ? WHERE ID = ?", [user.FAIL_COUNT + 1, userId]);
            return res.status(401).json({success : false, message : "아이디나 비밀번호가 일치하지않습니다."});
        }

        await db.query("UPDATE BOOK_LOGIN SET FAIL_COUNT = ? WHERE ID = ?", [0, userId]);

        console.log(`${userId} 로그인`);

        return res.status(200).json({success : true, message : `${userId}님 환영합니다.`, nickname : user.NICKNAME});


    }catch (err){
        console.error(err);
        return res.status(500).json({success : false, message : "로그인이 실패했습니다.\n잠시 후에 다시 시도해주세요."});
    }
});

app.post("/signUp", async (req, res) => {
    const {userId, password, nickname} = req.body;

    try{
        const [idRows] = await db.query('SELECT * FROM BOOK_LOGIN WHERE ID = ?', [userId]);
        if(idRows.length > 0) return res.status(400).json({success : false, message : "이미 사용중인 아이디입니다."});

        const hashedPassword = await bcrypt.hash(password, 10);

        await db.query('INSERT INTO BOOK_LOGIN(ID, PASSWORD, NICKNAME) VALUES (?, ?, ?)', [userId, hashedPassword, nickname]);

        console.log(`${userId} 회원가입`);

        return res.status(201).json({success : true, message : "회원가입이 완료되었습니다.\n인증 메일을 확인해주세요."});
    } catch(err){
        console.error("회원가입 오류 : ", err);
        return res.status(500).json({success : false, message : "회원가입에 실패했습니다."});
    }
});

app.post("/bookSearch", async (req, res) => {
    const { book } = req.body;

    try{
        const [rows] = await db.query("SELECT * FROM BOOK WHERE TITLE = ? AND BOOK_YN = 1", [book]);

        if(rows.length === 0){
            console.log("책을 찾지 못했습니다.");
            return res.status(404).json({success : false, message : "책을 찾을 수 없습니다."});
        }

        console.log("책을 찾았습니다.");
        return res.status(200).json({success : true, message : `${book}과 연관된 책은 ${rows.length} 권 있습니다.`, book : [rows[0].TITLE, rows[0].AUTHOR, rows[0].PLOT]});
    }catch(err){
        console.error(err);
        return res.status(500).json({success : false, message : "조회에 실패했습니다.\n잠시 후에 다시 시도해주세요."});
    }
});

app.post("/bookAdd", async (req, res) => {
    const { title, author, plot } = req.body;

    try{
        await db.query("INSERT INTO BOOK(TITLE, AUTHOR, PLOT, BOOK_YN) VALUES(?, ?, ?, 1)", [title, author, plot]);

        console.log("책을 넣었습니다.");
        return res.status(200).json({success : true, message : `${title}이 등록되었습니다.`});
    }catch(err){
        console.error(err);
        return res.status(500).json({success : false, message : "등록에 실패했습니다.\n잠시 후에 다시 시도해주세요."});
    }
});

https.createServer(options, app).listen(3333, () => console.log("서버가 연결되었습니다."));