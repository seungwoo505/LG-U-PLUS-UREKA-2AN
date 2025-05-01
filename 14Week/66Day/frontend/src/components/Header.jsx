import React, { useEffect } from 'react'
import style from './Header.module.css'
import { Link, NavLink } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import { setUserInfo } from '../store/userSlice';
import { getUserProfile, logoutUser } from '../api/userApi';

const Header = () => {
  const {userName} = useSelector(state => state.user.user);

  const dispatch = useDispatch();

  useEffect(() => {
    const getProfile = async () => {
      try {
        const res = await getUserProfile();

        dispatch(setUserInfo(res.data));
        
      } catch (error) {
        console.error('err---', error);
        dispatch(setUserInfo(''));
      }
    }

    getProfile();
  }, [dispatch])

  const handleLogout = async () => {
    try {
      const logout = logoutUser();
      console.log(logout);
      dispatch(setUserInfo(''));
    } catch (error) {
      console.error(error);
    }
  }

  return (
    <header className={style.header}>
        <h1>
            <Link to={'/'}>LOG</Link>
        </h1>
        <nav>
          {userName ? (
            <>
              <MenuLink to={'/create'} label={'글쓰기'} />
              <button onClick={handleLogout}>로그아웃</button>
              <span>{userName}</span>
            </>
          ) : (
            <>
              <MenuLink to={'/login'} label={'로그인'} />
              <MenuLink to={'/register'} label={'회원가입'} />
            </>
          )}
        </nav>
    </header>
  )
}

const MenuLink = ({to, label}) => (
  <NavLink to={to} className={({isActive}) => (isActive ? style.active : '')}>
    {label}
  </NavLink>
)

export default Header