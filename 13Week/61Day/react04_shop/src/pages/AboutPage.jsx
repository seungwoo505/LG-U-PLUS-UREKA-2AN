import React, { Suspense, lazy, useState } from 'react'
import '../lazy_test/lazyText.css'
// lazy를 사용하여 컴포넌트 동적 로딩
const LazyComponent = lazy(() => import('../lazy_test/LazyComponent'))
const LazyDashboard = lazy(() => import('../lazy_test/Dashboard'))
const LazyAnalytics = lazy(() => import('../lazy_test/Analytics'))

const AboutPage = () => {
  const [tab, setTab] = useState('dashboard')

  // 탭 변경 핸들러
  const handleTabChange = selectedTab => {
    setTab(selectedTab)
  }

  return (
    <main>
      <h2>AboutPage</h2>
      <h3>React 19 Lazy & Suspense 데모</h3>
      <div className="app-container">
        {/* 탭 내비게이션 */}
        <div className="tabs">
          <button
            onClick={() => handleTabChange('dashboard')}
            className={tab === 'dashboard' ? 'active' : ''}
          >
            대시보드
          </button>
          <button
            onClick={() => handleTabChange('analytics')}
            className={tab === 'analytics' ? 'active' : ''}
          >
            분석
          </button>
          <button
            onClick={() => handleTabChange('lazy')}
            className={tab === 'lazy' ? 'active' : ''}
          >
            지연 로딩 컴포넌트
          </button>
        </div>

        {/* Suspense를 사용한 로딩 상태 처리 */}
        <div className="content">
          <Suspense fallback={<div className="loading">로딩 중...</div>}>
            {tab === 'dashboard' && <LazyDashboard />}
            {tab === 'analytics' && <LazyAnalytics />}
            {tab === 'lazy' && <LazyComponent />}
          </Suspense>
        </div>
      </div>
    </main>
  )
}

export default AboutPage
