import React, { useState } from 'react';
import './App.css';
import Header from './Header';
import Footer from './Footer';

const Layout = () => {
    const [input, setInput] = useState("");
    return (
        <div className="container">
            <Header />
            <div className='main'>
                {input}
            </div>
            <Footer />  
        </div>
    );
};

export default Layout;