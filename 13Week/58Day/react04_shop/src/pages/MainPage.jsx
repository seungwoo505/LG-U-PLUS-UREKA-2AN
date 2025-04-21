import React, { lazy, Suspense } from 'react'

import LatestList from '../organism/LatestList'
const HeroSlider = lazy(() => import('@/organism/HeroSlider'))

const MainPAge = () => {
  return (
    <main>
      <h2 hidden>MainPage</h2>
      <Suspense fallback={<div>Loading slider...</div>}>
        <HeroSlider />
        <LatestList />
      </Suspense>
    </main>
  )
}

export default MainPAge
