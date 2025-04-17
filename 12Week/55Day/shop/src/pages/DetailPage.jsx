import React, { useEffect, useState } from 'react'
import { useParams }  from 'react-router-dom';
import { getDetailData } from '../api/DetailApi';
import style from './Detail.module.css';

const DetailPage = () => {
  const params = useParams();
  const [product, setProduct] = useState([]);
  const [count, setCount] = useState(1);

  const changeCount = (state) => {
    if(count <= 1 && state === "-") alert("1개가 최소입니다.")
    else setCount((prev) => state === "-" ? prev - 1 : prev + 1 );
  };

  useEffect(() => {
    const fetchDetail = async () => {
      const response = await getDetailData(params.productId);

      setProduct(response);
    }
    fetchDetail();
  }, []);

  return (
    <main>
      <section className={style.detail}>
        <img src={`/public/img/${product.img}`}/>
        <div className={style.textWrap}>
          <h2 className={style.title}>{product.title}</h2>
          <span className={style.price}>{`${Number(product.price).toLocaleString()}원`}</span>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eum, itaque corrupti commodi nulla, repellendus porro amet, excepturi numquam doloribus ducimus pariatur minima? Omnis eos aperiam autem odio possimus corporis sint.</p>
          <div className={style.cart}>
            <div className={style.count}>
              <span onClick={() => changeCount("-")}>-</span>
              {count}
              <span onClick={() => changeCount("+")}>+</span>
              </div>
            <div className={style.add}>ADD TO CART</div>
          </div>
        </div>
      </section>
    </main>
  )
}

export default DetailPage