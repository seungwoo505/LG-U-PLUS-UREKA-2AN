import React from 'react'
import { NavLink } from 'react-router-dom'
import style from './MenuList.module.css'

const MenuList = () => {
  return (
    <ul>
        <li>
            <NavLink to={'/'} className={(isActive) => isActive ? `${style.active}` : ''}>날씨API 활용</NavLink>
        </li>
    </ul>
  )
}

export default MenuList