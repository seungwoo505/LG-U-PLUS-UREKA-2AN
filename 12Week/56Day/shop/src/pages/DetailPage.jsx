import React, { useState } from 'react'
import { useLoaderData}  from 'react-router-dom';
import style from './Detail.module.css';
import { formatCurrency } from '../utils/features';

const DetailPage = () => {
  const {product, relatedProducts} = useLoaderData();
  const [count, setCount] = useState(1);

  const changeCount = (e) => {
    if(count <= 1 && e.target.textContent === "-") alert("1개가 최소입니다.")
    else setCount((prev) => e.target.textContent === "-" ? prev - 1 : prev + 1 );
  };

  return (
    <main>
      <h2>DetailPage</h2>
      <div className={style.detailCon}>
        <div className={style.imgWrap}>
          <img src={`/public/img/${product.img}`} alt={product.title}/>
          <p className={style.discount}>{product.discount} %</p>
        </div>
        <div className={style.infoWrap}>
          <p className={style.title}>{product.title}</p>
          <p className={style.price}>{formatCurrency(product.price)}</p>
          <p className={style.category}>{product.category}</p>
          <div className={style.btnWrap}>
            <div className={style.counterArea}>
              <button onClick={changeCount}>-</button>
              <span>{count}</span>
              <button onClick={changeCount}>+</button>
            </div>
            <button className={style.addBtn}>장바구니 담기</button>
          </div>
        </div>
      </div>
      <div>텝메뉴</div>
      <div>관련상품</div>
    </main>
  )
}

export default DetailPage