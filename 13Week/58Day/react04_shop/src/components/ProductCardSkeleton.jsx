import React from 'react'
import css from './ProductCardSkeleton.module.css'

const ProductCardSkeleton = () => {
  return (
    <div className={css.skeleton}>
      <div className={css.imgWrap}></div>
      <div className={css.textWrap}>
        <div className={css.title}></div>
        <div className={css.price}></div>
      </div>
    </div>
  )
}

export default ProductCardSkeleton
