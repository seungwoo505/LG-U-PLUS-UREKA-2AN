import React, { useEffect, useState } from 'react';

import { Swiper, SwiperSlide } from 'swiper/react'
// import required modules
import { Pagination } from 'swiper/modules'
import style from './HeroSlider.module.css';
import { Link } from 'react-router-dom';
import { getBannerData } from '../api/bannerApi';

const HeroSlider = () => {
    const [banner, setBanner] = useState([]);
    useEffect(() => {
        const fetchBanner = async () => {
            try{
                const data = await getBannerData();
            
                setBanner(data);
            }catch(err){
                console.log('err---', err);
            }
        }

        fetchBanner();
    }, []);
  return (
    <section>
      <h2 hidden>Banner Event</h2>
      <Swiper pagination={{clickable : true}} modules={[Pagination]} className={style.mainSlider}>
        {banner.map((item) => {
            return (
                <SwiperSlide key={item.id}>
                    <div className={style.imgWrap}>
                        <img src={item.img} alt={item.title}/>
                    </div>
                    <div className={style.textWrap}>
                        <p className={style.title}>{item.title}</p>
                        <p className={style.desc}>{item.desc}</p>
                        <Link to={item.link} className={style.more}>View Product</Link>
                    </div>
                </SwiperSlide>
            )
        })}
      </Swiper>
    </section>
  )
}

export default HeroSlider