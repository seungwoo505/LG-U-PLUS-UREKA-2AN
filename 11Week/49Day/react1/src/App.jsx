//rafce

import React, { useState } from 'react'
import Header from './components/header'
import InputFild from './components/InputFild'
import PostList from './components/PostList'

const App = () => {
  const list = ['송도', '인천', '서울', '부산']
  const [listData, setListData] = useState(list)

  const test = '샘플 테스트'
  const test2 = [1, 2, 3, 4, 5]
  const test3 = ['test1', 'test2', 'test3']
  const style = { color: 'blue' }
  const isFree = false

  const [data, setData] = useState('test')

  const changeText = () => {
    setData('변경된 데이터')
  }

  return (
    <>
      <p style={{ color: 'red' }}>여기 : {test}</p>
      <p style={style}>여기 : {test2}</p>
      <p>여기 : {test3}</p>
      {isFree ? <Header /> : <p>유료입니다.</p>}
      <button onClick={changeText}>변경</button>
      <Header />
      <InputFild />
      <PostList listData={listData} data={data} />
    </>
  )
}

export default App
