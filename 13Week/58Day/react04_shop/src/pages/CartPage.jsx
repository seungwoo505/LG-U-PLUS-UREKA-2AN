import React, { useState } from 'react'
import { useLoaderData } from 'react-router-dom'
import style from './CartPage.module.css';
import { formmatCurrency } from '@/utils/features';
import { removeCart, updateCartItem } from '@/api/cartApi';

const CartPage = () => {
  const cartList = useLoaderData();
  const [items, setItems] = useState(Array.isArray(cartList) ? cartList : []);
  console.log(cartList);

  const totalCount = items.reduce((sum, item) => sum + item.count, 0);
  const totalSum = items.reduce((sum, item) => sum + (item.count * item.price * (1-item.discount/100)), 0);

  const increase = (id) => {
    setItems(prev => prev.map(item => item.id === id ? {...item, count : item.count + 1} : item));

    const newCount = items.find(item => item.id === id).count + 1;

    updateCartItem(id, newCount);
  }

  const decrease = (id) => {
    setItems(prev => prev.map(item => (item.id === id && item.count > 1) ? {...item, count : item.count - 1} : item));

    const newCount = items.find(item => item.id === id).count - 1;
    if(newCount >= 1) updateCartItem(id, newCount);
  }

  const removeItem = (id) => {
    if(!window.confirm('정말 삭제하시겠습니까?')) return;

    setItems(prev => prev.filter(item => item.id !== id));
    removeCart(id);
  }

  return (
    <main>
      <h2>Shopping cart</h2>
      {items.length > 0 && (
        <p>You have <strong>{totalCount}</strong> item in your cart</p>
      )}

      {items.length === 0 ? (<p>장바구니 비어있음</p>) : (
        <>
          <ul className={style.cartList}>
            {items.map(item => {
              return (<li className={style.cartItem} key={item.id}>
                <div className={style.cartImg}>
                  <img src={`/public/img/${item.img}`} alt={item.title} />
                </div>
                <div className={style.cartTitle}>{item.title}</div>
                <div className={style.cartPrice}>{formmatCurrency(item.price)}</div>
                <div className={style.cartBtn}>
                  <button onClick={() => decrease(item.id)}>-</button>
                  <span>{item.count}</span>
                  <button onClick={() => increase(item.id)}>+</button>
                </div>
                <div className={style.cartSum}>합계 : {formmatCurrency(item.price * item.count)}</div>
                <div className={style.cartDelete} onClick={() => removeItem(item.id)}>
                  <i className='bi bi-trash3'></i>
                </div>
              </li>)
            })}
          </ul>
          <div className={style.cartTotalSum}>
            총 금액 : <strong>{formmatCurrency(totalSum)}</strong>
          </div>
        </>
      )}
    </main>
  )
}

export default CartPage
