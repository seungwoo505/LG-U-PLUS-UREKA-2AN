import React from 'react'
import {Swiper, SwiperSlide } from 'swiper/react';
import { Pagination} from 'swiper/modules';
import style from './SimilarProducts.module.css';
import ProductCard from '@/components/ProductCard';

const SimilarProducts = ({products}) => {
  return (
    <div className={style.con}>
        <Swiper
            slidesPerView={1}
            spaceBetween={10}
            pagination={{
                clickable: true
            }}
            breakpoints={{
                640: {
                    slidesPerView: 2,
                    spaceBetween: 20,
                },
                768: {
                    slidesPerView: 4,
                    spaceBetween: 40,
                },
                1024: {
                    slidesPerView: 5,
                    spaceBetween: 50,
                }
            }}
            modules={[Pagination]}
            className={style.similarSlider}
        >
            {products.map(product => (
                <SwiperSlide key={product.id}>
                    <ProductCard data={product} />
                </SwiperSlide>
            ))}
        </Swiper>
    </div>
  )
}

export default SimilarProducts