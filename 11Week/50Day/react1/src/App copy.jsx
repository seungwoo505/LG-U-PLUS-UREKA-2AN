//rafce

import React, { useState } from 'react'
import Header from './components/header'
import InputFild from './components/InputFild'
import PostList from './components/PostList'
import NoList from './components/NoList'

const App = () => {
  const [listData, setListData] = useState(JSON.parse(localStorage.getItem('list')) || [])

  return (
    <>
      <Header />
      <InputFild setListData={setListData} />
      {listData.length === 0 ? (
        <NoList />
      ) : (
        <PostList listData={listData} setListData={setListData} />
      )}
    </>
  )
}

export default App
