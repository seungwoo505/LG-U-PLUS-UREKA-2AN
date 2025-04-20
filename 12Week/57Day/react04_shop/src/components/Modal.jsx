import React, { useEffect, useState } from 'react'
import style from './Modal.module.css';
import { formmatCurrency } from '@/utils/features';
import { Navigate, useNavigate } from 'react-router-dom';
import { addToCart } from '@/api/cartApi';

const Modal = ({product, count, closeModal}) => {
    const [isActive, setIsActive] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {

        const timer = setTimeout(()=> {
            setIsActive(true);
            document.body.style.overflow = 'hidden';
        }, 5);

        return () => {
            clearTimeout(timer);
            document.body.style.overflow = 'auto';
        }
    }, []);

    const handleClose = () => {
        setIsActive(false);
        setTimeout(closeModal, 300);
    }

    const handleAddToCart = async () => {
        try{
        const cartItem =
        {
            id: product.id,
            title: product.title,
            img: product.img,
            price: product.price,
            category: product.category,
            discount: product.discount,
            count : count,
        }

        await addToCart(cartItem);
        handleClose();
        navigate('/cart');
        }catch(err){
            console.error("err---", err);
        }
    }
  return (
    <div className={`${style.modal} ${isActive ? style.active : ''}`}>
        <div className={style.container}>
            <div className={style.inner}>
                <h2>장바구니</h2>
                <div className={style.imgWrap}>
                    <img src={`/public/img/${product.img}`} alt={product.title} />
                </div>
                <div className={style.info}>
                    <p>{product.title}</p>
                    <p>{formmatCurrency(product.price)}</p>
                    {product.discount && <p>{product.discount}%</p>}
                    <p>{count}</p>
                    <p>총 가격 : {formmatCurrency(product.price * count)}</p>
                </div>
                <button onClick={handleClose}>취소</button>
                <button onClick={handleAddToCart}>장바구니 담기</button>
            </div>
            <button className={style.btnClose} onClick={handleClose}>
                <li className="bi bi-x-lg"></li>
            </button>
        </div>
    </div>
  )
}

export default Modal