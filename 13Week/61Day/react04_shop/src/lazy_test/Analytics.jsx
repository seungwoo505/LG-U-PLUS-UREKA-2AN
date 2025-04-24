import React, { useState, useEffect } from 'react'

function Analytics() {
  const [analyticsData, setAnalyticsData] = useState(null)

  useEffect(() => {
    // 분석 데이터 로딩 시뮬레이션
    const loadAnalytics = async () => {
      await new Promise(resolve => setTimeout(resolve, 1500))
      setAnalyticsData({
        pageViews: 12500,
        uniqueVisitors: 4200,
        bounceRate: '32%',
        avgSessionDuration: '3m 24s',
      })
    }

    loadAnalytics()
  }, [])

  return (
    <div className="analytics">
      <h2>분석 대시보드</h2>
      {analyticsData ? (
        <div className="analytics-data">
          <div className="metric">
            <h3>페이지뷰</h3>
            <p>{analyticsData.pageViews}</p>
          </div>
          <div className="metric">
            <h3>순 방문자</h3>
            <p>{analyticsData.uniqueVisitors}</p>
          </div>
          <div className="metric">
            <h3>이탈률</h3>
            <p>{analyticsData.bounceRate}</p>
          </div>
          <div className="metric">
            <h3>평균 세션 시간</h3>
            <p>{analyticsData.avgSessionDuration}</p>
          </div>
        </div>
      ) : (
        <p>분석 데이터 로딩 중...</p>
      )}
    </div>
  )
}

export default Analytics
