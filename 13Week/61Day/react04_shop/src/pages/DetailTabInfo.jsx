import React, { useState } from 'react'
import style from './DetailTabInfo.module.css';

const DetailTabInfo = () => {
    const [activeTab, setActive] = useState(0);
    const tabTiles = ['메뉴1', '메뉴2', '메뉴3'];

  return (
    <>
        <div className={style.tabBtn}>
            {tabTiles.map((title, i) => (
                <button key={i} className={activeTab === i ? style.active : ''} onClick={() => setActive(i)}>
                    {title}
                </button>
            ))}
        </div>
        <div className={`${style.tabContent} ${activeTab === 0 ? style.visible : ''}`}>
            <h3>제목</h3>
            <p>내용이 들어갑니다.</p>
            <p>내용이 들어갑니다.</p>
            <p>내용이 들어갑니다.</p>
            <p>내용이 들어갑니다.</p>
        </div>
        <div className={`${style.tabContent} ${activeTab === 1 ? style.visible : ''}`}>
            <h3>제목1</h3>
            <p>내용1이 들어갑니다.</p>
            <p>내용1이 들어갑니다.</p>
            <p>내용1이 들어갑니다.</p>
            <p>내용1이 들어갑니다.</p>
        </div>
        <div className={`${style.tabContent} ${activeTab === 2 ? style.visible : ''}`}>
            <h3>제목2</h3>
            <p>내용2이 들어갑니다.</p>
            <p>내용2이 들어갑니다.</p>
            <p>내용2이 들어갑니다.</p>
            <p>내용2이 들어갑니다.</p>
        </div>
    </>
  )
}

export default DetailTabInfo