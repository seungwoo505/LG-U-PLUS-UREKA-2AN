import dotenv from 'dotenv';
import express from 'express';
import cors from 'cors';
import mongoose from 'mongoose';
import { userModel } from './user.js';
import bcrypt from 'bcryptjs';
import jwt from 'jsonwebtoken';
import cookieParser from 'cookie-parser';

dotenv.config();

const app = express();
const port = process.env.PORT;
const saltRounds = process.env.BCRYPT_SALT_ROUNDS;
const secretKey = process.env.JWT_SECRET;
const tokenLife = process.env.JWT_EXPIRATION;

app.use(cors({
    origin : process.env.FRONTEND_URL,
    credentials : true // 쿠키 전송 허용
}));
app.use(express.json());
app.use(cookieParser());

mongoose
    .connect(
        process.env.MONGODB_URL
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
        return res.status(401).json({error : "로그인 필요"});
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
})

app.listen(port, () => {
    console.log(`${port}동작 성공`);
});