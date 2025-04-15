import React from 'react'
import Header from '../organism/Header'
import { Outlet } from 'react-router-dom'
import Footer from '../organism/Footer'

const Default = () => {
  return (
    <>
        <Header />
        <Outlet />
        <Footer />
    </>
  )
}

export default Default