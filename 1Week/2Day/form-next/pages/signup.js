import React, { useState } from 'react';

const SignupForm = () => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        if (!name) {
            alert('이름을 입력해 주세요.');
        } else {
            // 여기서 폼 제출 처리 로직을 추가할 수 있습니다.
            console.log('폼 제출됨:', { name, email, password });
        }
    };

    return (
        <div style={styles.container}>
            <h1 style={styles.title}>회원가입</h1>
            <form onSubmit={handleSubmit}>
                <label style={styles.label} htmlFor="name">이름:</label>
                <input
                    style={styles.input}
                    type="text"
                    id="name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                />

                <label style={styles.label} htmlFor="email">이메일:</label>
                <input
                    style={styles.input}
                    type="email"
                    id="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />

                <label style={styles.label} htmlFor="password">비밀번호:</label>
                <input
                    style={styles.input}
                    type="password"
                    id="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />

                <input
                    style={styles.submitButton}
                    type="submit"
                    value="가입하기"
                />
            </form>
        </div>
    );
};

const styles = {
    container: {
        fontFamily: 'Arial, sans-serif',
        backgroundColor: '#f4f4f4',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        flexDirection: "column",
        height: '100vh',
        margin: 0,
    },
    title: {
        textAlign: 'center',
        color: '#333',
    },
    label: {
        marginTop: '10px',
        display: 'block',
        color: '#555',
    },
    input: {
        width: '100%',
        padding: '10px',
        marginTop: '5px',
        border: '1px solid #ccc',
        borderRadius: '4px',
        boxSizing: 'border-box',
    },
    submitButton: {
        backgroundColor: '#5cb85c',
        color: 'white',
        border: 'none',
        padding: '10px',
        borderRadius: '4px',
        cursor: 'pointer',
        width: '100%',
        marginTop: '15px',
    },
};

export default SignupForm;