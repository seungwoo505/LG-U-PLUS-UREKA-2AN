import React, { useState, useEffect } from 'react'

function LazyComponent() {
  const [data, setData] = useState(null)

  useEffect(() => {
    // 데이터 로딩 시뮬레이션
    const fetchData = async () => {
      // 2초 후 데이터 로드
      await new Promise(resolve => setTimeout(resolve, 2000))
      setData({ message: '지연 로딩 컴포넌트가 성공적으로 로드되었습니다!' })
    }

    fetchData()
  }, [])

  return (
    <div className="lazy-component">
      <h2>지연 로딩된 컴포넌트</h2>
      {data ? <p>{data.message}</p> : <p>컴포넌트 내부 데이터 로딩 중...</p>}
    </div>
  )
}

export default LazyComponent
