import dotenv from 'dotenv';
import express from 'express';
import cors from 'cors';
import mongoose from 'mongoose';
import { userModel } from './user.js';
import bcrypt from 'bcryptjs';
import jwt from 'jsonwebtoken';
import cookieParser from 'cookie-parser';
import multer from 'multer';
import path from 'path';
import fs from 'fs';
import { postModel } from './post.js';
import {fileURLToPath} from 'url';


dotenv.config();

const app = express();
const port = process.env.PORT;
const saltRounds = process.env.BCRYPT_SALT_ROUNDS;
const secretKey = process.env.JWT_SECRET;
const tokenLife = process.env.JWT_EXPIRATION;
const uploadDir = "upload";
const __fileName = fileURLToPath(import.meta.url);
const __dirName = path.dirname(__fileName);

if(!fs.existsSync(uploadDir)){
    fs.mkdirSync(uploadDir);
}

const storage = multer.diskStorage({
    destination : (req, file, cb) => {
        cb(null, "upload/");
    },
    filename: (req, file, cb) => {
        const uniqueSuffix = Date.now() + "-" + Math.round(Math.random() * 1e9);
        cb(null, uniqueSuffix + path.extname(file.originalname));
      },
});
const upload = multer({storage});

const cookiesOption = {
    
}

app.use(cors({
    origin : process.env.FRONTEND_URL,
    credentials : true // 쿠키 전송 허용
}));
app.use(express.json());
app.use(cookieParser());

mongoose
    .connect(
        process.env.MONGODB_URL,
        {dbName : process.env.MONGODB_DB_NAME}
    )
    .then(() => {
        console.log('연결 완료')
    })
    .catch((err) => {
        console.error('연결 실패', err)
    });

app.get('/', () => {
    res.send('안녕 서버');
});

app.post('/register', async (req, res) => {
    const {userName, password } = req.body;

    const existingUser = await userModel.findOne({userName});

    if(existingUser){
        return res.json({message : '이미 존재하는 사용자입니다.'});
    }

    const newUser = new userModel({userName, password : bcrypt.hashSync(password, saltRounds)});
    const savedUser = await newUser.save();

    res.status(201).json({
        user : {
            userName : savedUser.userName,
            _id : savedUser._id
        }
    });
});

app.post('/login', async (req, res) => {
    try {
        const { userName, password } = req.body;
        const userDoc = await userModel.findOne({userName});

        if(!userDoc){
            return res.status(401).json({error : "등록되지않은 사용자입니다."});
        }

        const passCK = bcrypt.compareSync(password, userDoc.password);

        if(!passCK){
            return res.status(401).json({error : "비밀번호가 일치하지않습니다."});
        }else{
            // jwt 토큰 발행
            const {_id, userName } = userDoc;
            const payload = {id : _id, userName};
            const token = jwt.sign(payload, secretKey, {
                expiresIn : tokenLife
            });

            res.cookie('token', token, { 
                httpOnly : true, 
                secure : process.env.NODE_ENV === 'production',
                sameSite : "Strict"
            }).json(payload);
        }
    } catch (error) {
        console.error('에러---', err);
        res.status(500).json({error : "서버 에러"});
    }
});

app.get('/profile', (req, res) => {
    const { token } = req.cookies;
    console.log("로그인 확인", token);
    if(!token){
        return res.json({error : "로그인 필요"});
    }

    jwt.verify(token, secretKey, (err, info) => {
        if(err){
            return res.json({error : '로그인 필요'});
        }

        res.json(info);
    })
});

app.post('/logout', (req, res) => {
    //req.cookies.token = undefined;
    res.cookie("token", "", { 
        httpOnly : true, 
        secure : process.env.NODE_ENV === 'production',
        sameSite : "Strict",
        expires : new Date(0)
    }).json({message : "로그아웃되었습니다."});
});

app.get('/loginCheck', (req, res) => {
    console.log(req.cookies);

    const { token } = req.cookies;

    if(!token){
        return res.status(200).json({message : "로그아웃되어있습니다."});
    }else{
        return res.status(200).json({message : "로그인이 되어있습니다."});
    }
});

app.post('/postWrite', upload.single('files'), async (req, res) => {

    console.log(req.file);
    const {token} = req.cookies;

    if(!token){
        return res.json({error : '로그인 필요'});
    }
    const userInfo = jwt.verify(token, secretKey);

    const {title, summary, content} = req.body;

    const postData = {
        title,
        summary,
        content,
        cover : req.file ? req.file.path : null,
        author : userInfo.userName
    };

    const post = await postModel.create(postData);

    console.log("개시글 작성 완료", post);

    res.json({message : '게시글 작성 성공'})
});

app.use("/upload", express.static(path.join(__dirName, "upload")));

app.get("/upload/:filename", (req, res) => {
  const { fileName } = req.params;
  res.sendFile(path.join(__dirName, "upload", fileName));
});

app.get('/postList', async (req, res) => {
    try {
        const posts = await postModel.find().sort({createAt : -1}).limit(3);
        res.json(posts);
    } catch (error) {
        console.error("err---", error);
        return res.status(500).json({error : "게시글 목록 조회 실패"});
    }
});

app.get('/postDetail/:postId', async (req, res) => {
    const {postId} = req.params;

    try {
        const post = await postModel.findById(postId);

        if(!post){
            return  res.status(404).json({error : "게시글을 찾을 수 없습니다."});
        }
        res.json(post);
    } catch (error) {
        console.error("err---", error);
        res.status(500).json({error : "게시물 상세 조회 실페"})
    }
});

app.listen(port, () => {
    console.log(`${port}동작 성공`);
});