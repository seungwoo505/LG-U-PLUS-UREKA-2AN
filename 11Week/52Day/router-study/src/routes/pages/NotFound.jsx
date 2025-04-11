import React from 'react'
import { NavLink } from 'react-router-dom'

const NotFound = () => {
  return (
    <div>
        <h2>잘못된 접근</h2>
        <NavLink to={"/"}>홈으로</NavLink>
    </div>
  )
}

export default NotFound