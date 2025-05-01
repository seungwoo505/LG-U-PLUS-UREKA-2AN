import React, { useState } from 'react';
import style from './RegisterPage.module.css';
import { useNavigate } from 'react-router-dom';
import { registerUser } from '../api/userApi';

const RegisterPage = () => {
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const [passwordCK, setPasswordCK] = useState('');
    const [errUserName, setErrUserName] = useState('');
    const [errPassword, setErrPassword] = useState('');
    const [errPasswordCK, setErrPasswordCK] = useState('');
    const [registerState, setRegisterState] = useState('등록중');

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

    const validatePasswordCK = (value, current = password) => {
        if(!value){
            setErrPasswordCK('');
            return;
        }
        if(value === current){
            setErrPasswordCK('');
        }else{
            setErrPasswordCK('패스워드가 일치하지않습니다.')
        }
    }

    const handlePasswordCKChange = (e) => {
        const value = e.target.value;
        setPasswordCK(value);
        validatePasswordCK(value);
    }
    
    const register = async e => {
        e.preventDefault();
        validateUserName(userName);
        validatePassword(password);
        validatePasswordCK(passwordCK, password);

        if(errUserName || errPassword || errPasswordCK || !userName || !password || !passwordCK){
            console.log('어딘가에 오류가 있어');
            return;
        }

        try {
            setRegisterState('등록중');

            const response = await registerUser({userName, password});

            console.log(response.data);

            setRegisterState('등록 완료');
            navigate('/login');
        } catch (error) {
            setRegisterState('등록 중 오류가 발생했습니다.');
            console.error('err --- ', error);
        }
    }
  return (
    <main className={style.registerPage}>
        <h2>회원가입 페이지</h2>
        {registerState && <strong>{registerState}</strong>}
        <form className={style.container} onSubmit={register}>
            <input 
                type='text' 
                placeholder='사용자명' 
                value={userName} 
                onChange={handleUserNameChange}
            />
            <strong>{errUserName}</strong>
            <input type='password' placeholder='비밀번호' value={password} onChange={handlePasswordChange}/>
            <strong>{errPassword}</strong>
            <input type='password' placeholder='패스워드확인' value={passwordCK} onChange={handlePasswordCKChange}/>
            <strong>{errPasswordCK}</strong>
            <button type='submit'>가입하기</button>
        </form>
    </main>
  )
}

export default RegisterPage