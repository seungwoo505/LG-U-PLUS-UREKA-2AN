import express from 'express';
import cors from 'cors';

const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

import mongoose from 'mongoose';
import { userModel } from './user.js';

mongoose
    .connect(
        'mongodb+srv://seungwoo:*seungwoo505*@ureka.nlxmbnp.mongodb.net/blog?retryWrites=true&w=majority&appName=ureka'
    )
    .then(() => {
        console.log('연결 완료')
    })
    .catch((err) => {
        console.error('연결 실패', err)
    })

app.get('/', () => {
    res.send('안녕 서버');
});

app.post('/register', async (req, res) => {
    const {userName, password } = req.body;

    const existingUser = await userModel.findOne({userName});

    if(existingUser){
        return res.json({message : '이미 존재하는 사용자입니다.'});
    }

    const newUser = new userModel({userName, password});
    const savedUser = await newUser.save();

    res.status(201).json({
        user : {
            userName : savedUser.userName,
            _id : savedUser._id
        }
    });
});

app.listen(port, () => {
    console.log(`${port}동작 성공`);
});