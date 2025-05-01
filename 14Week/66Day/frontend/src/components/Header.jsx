import React from 'react'
import style from './Header.module.css'
import { Link, NavLink } from 'react-router-dom'

const Header = () => {
  return (
    <header className={style.header}>
        <h1>
            <Link to={'/'}>LOG</Link>
        </h1>
        <NavLink to={'/register'}>
            회원가입
        </NavLink>
    </header>
  )
}

export default Header