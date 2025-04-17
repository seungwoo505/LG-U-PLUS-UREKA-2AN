import React from 'react'
import style from './ProductCardSkeleton.module.css';

const ProductCardSkeleton = () => {
  return (
    <div className={style.skeleton}>
        <div className={style.imgWrap}></div>
        <div className={style.textWrap}>
            <div className={style.title}></div>
            <div className={style.price}></div>
        </div>
    </div>
  )
}

export default ProductCardSkeleton