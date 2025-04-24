import React, { Suspense } from 'react'

import Header from '@/organism/Header'
import Footer from '@/organism/Footer'
import { Outlet } from 'react-router-dom'

const Default = () => {
  return (
    <>
      <Header />
      <Suspense fallback={<div>Loading...</div>}>
        <Outlet />
      </Suspense>
      <Footer />
    </>
  )
}

export default Default
