import React, { useEffect, useState } from 'react'
import { Swiper, SwiperSlide } from 'swiper/react'
import { Link } from 'react-router-dom'
import { Navigation, Pagination, Autoplay } from 'swiper/modules'
import { getBannerData } from '../api/bannerApi'

import css from './HeroSlider.module.css'

const delay = ms => new Promise(resolve => setTimeout(resolve, ms))

const HeroSlider = () => {
  const [banner, setBanner] = useState([])
  const [loading, setLoading] = useState(false)

  useEffect(() => {
    const fetchBanner = async () => {
      try {
        setLoading(true)
        const data = await getBannerData()

        // 스켈레톤 효과를 주기 위해 3초 대기
        // 실제 서비스에서는 사용하지 않음
        await delay(300)

        setBanner(data)
        setLoading(false)
      } catch (err) {
        console.log(err)
        setLoading(false)
      }
    }
    fetchBanner()
  }, [])

  return (
    <section>
      <h2 hidden>Banner Event</h2>

      <Swiper
        pagination={{ clickable: true }}
        modules={[Navigation, Pagination, Autoplay]}
        className={css.mainSlider}
      >
        {loading ? (
          <SwiperSlide>
            <div className={`${css.skletion} ${css.imgWrap}`}></div>
          </SwiperSlide>
        ) : (
          banner.map(item => (
            <SwiperSlide key={item.id}>
              <div className={css.imgWrap}>
                <img src={item.img} alt={item.title} />
              </div>
              <div className={css.textWrap}>
                <p className={css.title}>{item.title}</p>
                <p className={css.desc}>{item.description}</p>
                <Link to={item.link} className={css.more}>
                  View Product
                </Link>
              </div>
            </SwiperSlide>
          ))
        )}
      </Swiper>
    </section>
  )
}

export default HeroSlider
