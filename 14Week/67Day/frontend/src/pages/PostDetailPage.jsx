import React, { useEffect, useState } from 'react'
import style from './PostDetailPage.module.css';
import { useParams } from 'react-router-dom';
import { getPostDetail } from '../api/postApi';
import DOMPurify from 'dompurify';
import { formatDate } from '../utils/features';

const PostDetailPage = () => {
    const { postId } = useParams();
    const [post, setPost] = useState({});

    const cleanHtml = DOMPurify.sanitize(post?.content);
    console.log('cleanHtml', cleanHtml);

    useEffect(() => {
        const fetchPostDetail = async () => {
            try {
                const response = await getPostDetail(postId);

                setPost(response);
            } catch (error) {
                console.error('err', error);
            }
        }

        fetchPostDetail();
    }, [postId]);

  return (
    <main className={style.PostDetailPage}>
        <h2>상세 페이지</h2>
        <section className={style.postSection}>
            <div className={style.detail_img}>
                <img src={`${import.meta.env.VITE_BACK_URL}/${post.cover}`} alt={post.title} />
                <h3>{post.title}</h3>
            </div>
            <div className={style.info}>
                <p className={style.author}>{post.author}</p>
                <p className={style.date}>{formatDate(post.createAt)}</p>
            </div>
            <div className={style.summary}>{post.summary}</div>
            <div className={style.content} dangerouslySetInnerHTML={{__html : cleanHtml }}>
            </div>
        </section>
        <div className={style.btns}>
            <button>수정</button>
            <button>삭제</button>
            <button>목록</button>
        </div>
        <section className={style.comments}>댓글 리스트</section>
    </main>
  )
}

export default PostDetailPage