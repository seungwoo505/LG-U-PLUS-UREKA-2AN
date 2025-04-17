import React from 'react'
import style from './ProductCard.module.css';
import { Link } from 'react-router-dom'
const ProductCard = ({data}) => {
  return (
    <div className={style.card}>
        <div className={style.imgWrap}>
            <img src={`/public/img/${data.img}`} alt={data.title}/>
            <span className={style.cate}>new</span>
            <span className={style.discount}>{data.discount}%</span>
        </div>
        <div className={style.textWrap}>
            <strong className={style.title}>{data.title}</strong>
            <span className={style.price}>{`${Number(data.price).toLocaleString()}원`}</span>
        </div>
        <Link to={`/detail/${data.id}`} className={style.btnGoDetail}>상품 상세 페이지</Link>
    </div>
  )
}

export default ProductCard