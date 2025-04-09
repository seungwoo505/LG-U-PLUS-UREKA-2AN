import React, { useState } from 'react'
import css from './sample.module.css'

const App = () => {
  const [age, setAge] = useState(10)
  const [userInfo, setUserInfo] = useState({
    userName: 'seungwoo',
    artwork: {
      title: '이미지제목',
      artist: '이승우',
      imgUrl: 'https://picsum.photos/id/1/200/300',
    },
  })

  const increment = () => {
    setAge(prev => prev + 1)
    //setAge(age + 1)
  }

  const handleNameChange = e => {
    setUserInfo({
      ...userInfo,
      userName: e.target.value,
    })
  }

  const handleTitleChange = e => {
    setUserInfo({
      ...userInfo,
      artwork: {
        ...userInfo.artwork,
        title: e.target.value,
      },
    })
  }

  const handleArtistChange = e => {
    setUserInfo({
      ...userInfo,
      artwork: {
        ...userInfo.artwork,
        artist: e.target.value,
      },
    })
  }

  const handleImageChange = e => {
    setUserInfo({
      ...userInfo,
      artwork: {
        ...userInfo.artwork,
        imgUrl: e.target.value,
      },
    })
  }
  return (
    <>
      <div className="app3">
        <h1>연습</h1>
        <button
          onClick={() => {
            increment()
            increment()
            increment()
          }}
        >
          +3
        </button>
        <button
          onClick={() => {
            increment()
          }}
        >
          +1
        </button>
        <h2>입력 값 : {age}</h2>
        <br></br>
        <h1>연습2</h1>
        <label htmlFor="userName">이름 : </label>
        <input type="text" id="userName" value={userInfo.userName} onChange={handleNameChange} />
        <label htmlFor="userName">이미지 제목 : </label>
        <input
          type="text"
          id="userName"
          value={userInfo.artwork.title}
          onChange={handleTitleChange}
        />
        <label htmlFor="artist">작가 : </label>
        <input
          type="text"
          id="artist"
          value={userInfo.artwork.artist}
          onChange={handleArtistChange}
        />
        <label htmlFor="artist">이미지 정보 : </label>
        <input
          type="text"
          id="imgUrl"
          value={userInfo.artwork.imgUrl}
          onChange={handleImageChange}
        />
      </div>
      <div className={`${css.imgCon} mw`}>
        <p>{userInfo.artwork.title}</p>
        <p>{userInfo.artwork.artist}</p>
        <img src={userInfo.artwork.imgUrl} alt={userInfo.artwork.title} />
      </div>
    </>
  )
}

export default App