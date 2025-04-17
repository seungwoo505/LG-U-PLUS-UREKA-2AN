import React, { useEffect, useState } from 'react'
import { Link, NavLink, useLocation } from 'react-router-dom';
import style from './Header.module.css';
import Logo from '../components/Logo';
import { throttle } from '../utils/features';

const Header = () => {
  const [isOn, setIsOn] = useState(false);
  const location = useLocation();

  const addClassOn = () => {
    setIsOn(!isOn);
  }

  useEffect(() => {
    setIsOn(false);
  }, [location.pathname]);

  const handleResize = throttle(() => {
    if(window.innerWidth > 1100){
      setIsOn(false);
    }
  }, 1000);

  useEffect(() => {
    window.addEventListener('resize', () => handleResize)

    return () => {
      window.removeEventListener('resize', handleResize);
    }
  }, []);
  return (
    <header className={style.hd}>
      <div className={style.con}>
        <h1 className={style.logo}>
          <Link to={'/'}>
            <Logo />
          </Link>
        </h1>
        <div className={isOn ? `${style.gnb} ${style.on}` : style.gnb}>
          <nav>
            <CustomNavLink to={'/shop'} label={'shop'} />
            <CustomNavLink to={'/blog'} label={'blog'} />
            <CustomNavLink to={'/about'} label={'about'} />
          </nav>
          <div className={style.icon}>
            <CustomIconLink to={"/search"} icon={"search"} />
            <CustomIconLink to={"/mypage"} icon={"person-circle"} />
            <CustomIconLink to={"/cart"} icon={"cart"} />
          </div>
        </div>
        <i className={`${style.ham} bi bi-list`} title='전체메뉴 보기 버튼' onClick={addClassOn}></i>
      </div>
    </header>
  )
}

const CustomNavLink = ({to, label}) => {
  return <NavLink className={({ isActive }) => (isActive ? `${style.active}` : "")} to={to}>{label}</NavLink>;
}

const CustomIconLink = ({to, icon}) => {
  return <NavLink className={({ isActive }) => (isActive ? `${style.active}` : "")} to={to}><i className={`bi bi-${icon}`}></i></NavLink>;
}
export default Header