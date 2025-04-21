import React, { useState } from 'react'
import style from './ShopPage.module.css';

const ShopPage = () => {
  const [isDown, setIsDown] = useState(false);
  return (
    <main className={style.shopPage}>
      <h2>ShopPage</h2>
      <div className={style.searchFn}>
        <div className={style.category}>
          <button className={style.active}>전체 상품</button>
          <button>신상품</button>
          <button>인기상품</button>
        </div>
        <div className={`${style.sort} ${isDown ? style.active : ""}`}>
          <div className={style.sortHeader} onClick={() => setIsDown(!isDown)}>
            <p>등록순</p>
            <i className={`bi bi-chevron-up`}></i>
          </div>
          <ul>
            <li className={style.active}>등록순</li>
            <li>낮은 가격순</li>
            <li>높은 가격순</li>
            <li>낮은 할인순</li>
            <li>높은 할인순</li>
          </ul>
        </div>
      </div>
      <div className={style.productList}>
        <ul className={style.list}>
          <li>
            상품리스트
          </li>
        </ul>
        <div className={style.paginationArea}>
          <button>
            <i className='bi bi-chevron-left'></i>
          </button>
          <button className={style.active}>1</button>
          <button>2</button>
          <button>3</button>
          <button>4</button>
          <button>5</button>
          <button>
            <i className='bi bi-chevron-right'></i>
          </button>
        </div>
      </div>
    </main>
  )
}

export default ShopPage
