export const formmatCurrency = number => {
  return number.toLocaleString() + '원'
}

export const formatDate = date => {
  const d = new Date(date)
  const year = d.getFullYear()
  // getMonth()는 0부터 시작하므로 1을 더하고, 10보다 작으면 앞에 0 추가
  const month = String(d.getMonth() + 1).padStart(2, '0')
  const day = String(d.getDate()).padStart(2, '0')

  return `${year}. ${month}. ${day}`
}

// 디바운스 : 연속된 호출을 지연시켜 한번만 실행. 함수(함수, 대시시간)
export const debounce = (func, delay = 300) => {
  let timerId
  return function (...args) {
    if (timerId) clearTimeout(timerId)
    timerId = setTimeout(() => {
      func.apply(this, args)
    }, delay)
  }
}

// 쓰로틀 : 일정 시간 동안 한 번만 실행. 함수(함수, 대시시간)
export const throttle = (func, limit = 300) => {
  let inThrottle
  return function (...args) {
    // 일반 함수로 변경
    if (!inThrottle) {
      func.apply(this, args)
      inThrottle = true
      setTimeout(() => (inThrottle = false), limit)
    }
  }
}
