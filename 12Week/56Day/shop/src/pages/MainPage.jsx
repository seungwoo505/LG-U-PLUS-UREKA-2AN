import React from 'react'
import HeroSlider from '../organism/HeroSlider'
import LatestList from '../organism/LatestList'

const MainPage = () => {
  return (
    <main>
        <h2>메인 페이지</h2>
        <HeroSlider />
        <LatestList />
    </main>
  )
}

export default MainPage