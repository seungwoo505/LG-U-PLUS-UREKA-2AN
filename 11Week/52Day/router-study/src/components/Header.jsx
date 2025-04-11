import React from 'react'
import {NavLink} from 'react-router-dom';
import Shelly from '../assets/Shelly.svg';
import style from './Header.module.css';

const Header = () => {
  return (
    <header className={style.hd}>
        <h1>
          <NavLink to={'/'}>
            <img src={Shelly}/>
          </NavLink>
        </h1>
        <nav>
          {/*
            router에서 Link와 NavLink를 제공하는데
            NavLink는 Link와 다르게 주소에 해당하는 태그에 class='active'가 추가된다.
           */}
          <NavLink to={'/about'}>회사소개</NavLink>
          <NavLink to={'/shop'}>쇼핑</NavLink>
          <NavLink to={'/'}>링크</NavLink>
        </nav>
    </header>
  )
}

export default Header