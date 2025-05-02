import React, { useEffect, useState } from 'react'
import style from './postListPage.module.css';
import PostCard from '../components/PostCard';
import { getPostListApi } from '../api/postApi';

const PostListPage = () => {
    const [postList, setPostList] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    useEffect(() => {
        const fetchPostList = async () => {
            try {
                setLoading(true);
                setError(null);
                const data = await getPostListApi();
                setPostList(data);
                setLoading(false);
            } catch (error) {
                console.error("err --- ", error);
                setError("데이터 가져오는 중 오류가 발생했습니다.");
            }
        }

        fetchPostList();
    }, [])
  return (
    <main className={style.PostListPage}>
        <h2>리스트</h2>
        {error && <p className={style.error}>{error}</p>}
        {loading ? (<p>로딩중...</p>) : postList.length === 0 ? (<p>게시물이 없습니다.</p>) : (
            <ul className={style.postList}>
                {postList.map(post => (
                    <li key={post._id}>
                        <PostCard post={post} />
                    </li>
                ))}
            </ul>
        )}
    </main>
  )
}

export default PostListPage