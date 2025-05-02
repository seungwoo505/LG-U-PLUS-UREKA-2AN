import React, { useState } from 'react';
import style from './createPost.module.css';
import QuillEditor from '../components/QuillEditor';
import { createPostApi } from '../api/postApi';
import { useNavigate } from 'react-router-dom';

const CreatePost = () => {
    const [title, setTitle] = useState('');
    const [summary, setSummary] = useState('');
    const [files, setFiles] = useState([]);
    const [content, setContent] = useState('');
    const [isSubmitting, setIsSubmitting] = useState(false);
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleContentChange = (content) => {
        setContent(content);
    }

    const createPost = async (e) => {
        e.preventDefault();
        setIsSubmitting(true);
        setError('');

        if(!title || !summary || !content){
            setIsSubmitting(false);
            setError('모든 필드를 입력해주세요.');
            return;
        }

        const data = new FormData();
        data.set('title', title);
        data.set('summary', summary);
        data.set('content', content);

        if(files[0]){
            data.set('files', files[0]);
        }

        try {
            await createPostApi(data);
                
            setIsSubmitting(false);
            navigate('/');
        } catch (error) {
            console.error('err', error)
            setIsSubmitting(false);
            setError('');
        }
    }
  return (
    <main className={style.createPost} onSubmit={createPost}>
        <h2>글쓰기</h2>
        <form className={style.writeCon}>
            <label htmlFor='title'>제목</label>
            <input type='text' id='title' name='title' value={title} onChange={e=>setTitle(e.target.value)} required />
            <label htmlFor='summary'>요약</label>
            <input type='text' id='summary' name='summary' value={summary} onChange={e=>setSummary(e.target.value)} required />
            <label htmlFor='file'>파일</label>
            <input type='file' id='files' name='files' accept='image/*' onChange={e=>setFiles(e.target.files)} />
            <label htmlFor='content'>내용</label>
            <div className={style.editorWrapper}>
                <QuillEditor value={content} onChange={handleContentChange} placeholder={"내용을 입력해주세요."} />
            </div>
            <button type='submit' disabled={isSubmitting}>등록</button>
        </form>
        {error}
    </main>
  )
}

export default CreatePost