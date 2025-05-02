import React from 'react'
import style from './PostCard.module.css';
import { useNavigate } from 'react-router-dom';

const PostCard = ({ post }) => {
    const { title, content, createAt, author, cover, _id} = post;
    const navigate = useNavigate();

    const goDetailPage = () => {
        navigate(`/detail/${_id}`);
    }
  return (
    <article className={style.PostCard} onClick={goDetailPage}> 
        <h3>{title}</h3>
        <p className={style.img}>
            <img src={`${import.meta.env.VITE_BACK_URL}/${cover}`} alt='이미지 이름' />
        </p>
        <p className={style.title}>{content}</p>
        <p className={style.createAt}>{createAt}</p>
        <p className={style.author}>{author}</p>
    </article>
  )
}

export default PostCard