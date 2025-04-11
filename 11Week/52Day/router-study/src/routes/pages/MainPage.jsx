import React from 'react'
import { NavLink, Outlet } from 'react-router-dom'
import { Swiper, SwiperSlide} from 'swiper/react';
import { Autoplay, Pagination, Navigation} from 'swiper/modules';
//import style from './Main.module.css';

const MainPage = () => {
  return (
    <div>
      <h2>MainPage</h2>
      <Swiper 
        slidesPerView={3}
        spaceBetween={30}
        centeredSlide={true}
        autoplay={{
          delay: 2500,
          disableOnInteraction : false,
        }}
        pagination={{
          clickable: true
        }}
        navigation={true} 
        modules={[Autoplay, Pagination, Navigation]} 
        //className={style.slider}
        className='slider'
      >
        <SwiperSlide>
          <div className='card'>
            <img src='/public/img/Img_bg1.jpg' alt='bg1' />
          </div>
        </SwiperSlide>
        <SwiperSlide>Slide 1</SwiperSlide>
        <SwiperSlide>Slide 2</SwiperSlide>
        <SwiperSlide>Slide 3</SwiperSlide>
        <SwiperSlide>Slide 4</SwiperSlide>
        <SwiperSlide>Slide 5</SwiperSlide>
        <SwiperSlide>Slide 6</SwiperSlide>
        <SwiperSlide>Slide 7</SwiperSlide>
        <SwiperSlide>Slide 8</SwiperSlide>
        <SwiperSlide>Slide 9</SwiperSlide>
      </Swiper>
      <nav>
        <NavLink>리스트1</NavLink>
        <NavLink>리스트2</NavLink>
        <NavLink>리스트3</NavLink>
      </nav>
      <div>아래는 outlet 영역</div>
      <Outlet />
    </div>
  )
}

export default MainPage