import React, { useEffect, useState } from 'react';

import { Swiper, SwiperSlide } from 'swiper/react'
// import required modules
import { Pagination } from 'swiper/modules'
import style from './HeroSlider.module.css';
import { Link } from 'react-router-dom';
import { getBannerData } from '../api/bannerApi';

const delay = (ms) => new Promise(resolve => setTimeout(resolve, ms));

const HeroSlider = () => {
    const [banner, setBanner] = useState([]);
    const [loading, setLoading] = useState(false);
    useEffect(() => {
        const fetchBanner = async () => {
            try{
                setLoading(true);
                const data = await getBannerData();
            
                setBanner(data);
            }catch(err){
                console.log('err---', err);
            }
            await delay(1000);
            setLoading(false);
        }

        fetchBanner();
    }, []);
  return (
    <section>
      <h2 hidden>Banner Event</h2>
      <Swiper pagination={{clickable : true}} modules={[Pagination]} className={style.mainSlider}>
        {loading ? (
            <SwiperSlide>
                <div className={`${style.skletion} ${style.imgWrap}`}></div>
            </SwiperSlide>
        ) : (
        banner.map((item) => {
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
        }))}
      </Swiper>
    </section>
  )
}

export default HeroSlider