import React from 'react'
import MenuList from './MenuList'
import { Outlet } from 'react-router-dom'
import style from './MainLayout.module.css';

const MainLauout = () => {
  return (
    <div className={style.layout}>
        <MenuList />
        <Outlet />
    </div>
  )
}

export default MainLauout