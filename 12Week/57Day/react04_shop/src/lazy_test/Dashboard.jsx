import React from 'react'

function Dashboard() {
  return (
    <div className="dashboard">
      <h2>대시보드</h2>
      <p>이것은 lazy로 로드된 대시보드 컴포넌트입니다.</p>
      <div className="dashboard-widgets">
        <div className="widget">사용자 통계</div>
        <div className="widget">활동 요약</div>
        <div className="widget">최근 알림</div>
      </div>
    </div>
  )
}

export default Dashboard
