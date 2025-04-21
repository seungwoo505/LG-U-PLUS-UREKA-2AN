import React from 'react'
import { useRouteError } from 'react-router-dom'

const NotFound = () => {
  const error = useRouteError()
  return (
    <main>
      <h2>NotFound</h2>
      <p>
        {error.status === 404 ? '요청한 페이지를 찾을 수 없습니다.' : '잠시후 재 실행 해주세요'}
        {error.data || error.statusText}
      </p>
    </main>
  )
}

export default NotFound
