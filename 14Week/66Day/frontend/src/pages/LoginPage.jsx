import React, { useState } from 'react'
import style from './RegisterPage.module.css';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { setUserInfo } from '../store/userSlice';
import { loginUser } from '../api/userApi';

const LoginPage = () => {
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const [errUserName, setErrUserName] = useState('');
    const [errPassword, setErrPassword] = useState('');
    const [loginStatus, setLoginStatus] = useState('');
    const [redirect, setRedirect] = useState('');

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const validateUserName = value => {
        if(!value){
            setErrUserName('');
            return ;
        }
        if(!/^[a-zA-Z][a-zA-Z0-9]{3,}$/.test(value)){
            setErrUserName('사용자명은 영문자로 시작하는 4자리 이상인 영문자 또는 숫자이어야합니다.');
        }else{
            setErrUserName('');
        }
    }

    const handleUserNameChange = (e) => {
        const value = e.target.value;
        setUserName(value);
        validateUserName(value);
    }

    const validatePassword = value => {
        if(!value){
            setErrPassword('');
            return ;
        }
        if(value.length < 4){
            setErrPassword('패스워드는 4자 이상이어야합니다.');
        }else{
            setErrPassword('');
        }
    }
    
    const handlePasswordChange = (e) => {
        const value = e.target.value;
        setPassword(value);
        validatePassword(value);
    }

    const login = async e => {
        e.preventDefault();
        validateUserName(userName);
        validatePassword(password);

        if (errUserName || errPassword || !userName || !password) {
            setLoginStatus('아이디와 패스워드를 확인해주세요');
            return;
        }

        try{
            const response = await loginUser({userName, password})

            if(response.status === 200){
                setLoginStatus('로그인 성공');
                dispatch(setUserInfo(response.data));
                console.log(response);
                setRedirect(true);
                setTimeout(() => {
                    navigate('/');
                }, 1000);
            }else{
                setLoginStatus('아이디 및 패스워드가 일치하지않습니다.');
                console.log(response);
                setRedirect(false);
            }
        }catch(err){
            console.error('err--', err);
        }finally{
            setUserName('');
            setPassword('');
        }
    }
  return (
    <main className={style.loginPage}>
        <h2>로그인 페이지</h2>
        <form className={style.container} onSubmit={login}>
            <input 
                type="text"
                placeholder='아이디'
                value={userName} 
                onChange={handleUserNameChange}
            />
            <strong>{errUserName}</strong>
            <input 
                type='password' 
                placeholder='패스워드'
                value={password}
                onChange={handlePasswordChange}
            />
            <strong>{errPassword}</strong>
            <button type='submit'>로그인</button>
            <strong>{loginStatus}</strong>
        </form>
    </main>
  )
}

export default LoginPage