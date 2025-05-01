import React, { useState } from 'react';
import style from './createPost.module.css';
import QuillEditor from '../components/QuillEditor';
import { createPostApi } from '../api/postApi';
import { useNavigate } from 'react-router-dom';

const CreatePost = () => {
    const [title, setTitle] = useState('');
    const [summary, setSummary] = useState('');
    const [files, setFiles] = useState('');
    const [content, setContent] = useState('');
    const [isSubmitting, setIsSubmitting] = useState(false);
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleContentChange = () => {
        setContent(content);
    }

    const createPost = async (e) => {
        e.preventDefault();
        setIsSubmitting(true);
        setError('');

        try {
            if(!title || !summary || !content){
                setError('모든 필드를 입력해주세요.');
                return;
            }

            const data = new FormData();
            data.set('title', title);
            data.set('summary', summary);
            data.set('content', content);

            if(files[0]){

                // 1024 * 1024 = 1MB
                console.log('파일 크기 : ', files[0].size);
                console.log('파일 형식 : ', files[0].type);
                data.set('file', files[0]);
            }

            try {
                setIsSubmitting(true);

                const postData = await createPostApi(data);
                
                setIsSubmitting(false);
                console.log("Post", postData);
                navigate('/');
            } catch (error) {
                console.error('err', error)
            }
            
        } catch (error) {
            console.error('error---', error);
            setError('', error.message);
        }finally{
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
            <input type='file' id='file' name='file' accept='image/*' value={files} onChange={e=>setFiles(e.target.value)} />
            <label htmlFor='content'>내용</label>
            <div className={style.editorWrapper}>
                <QuillEditor value={content} onChange={handleContentChange} placeholder={"내용을 입력해주세요."} />
            </div>
            <button type='submit' disabled={isSubmitting}>등록</button>
        </form>
    </main>
  )
}

export default CreatePost