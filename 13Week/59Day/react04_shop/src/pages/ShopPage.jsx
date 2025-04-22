import React, { useState } from 'react'
import style from './ShopPage.module.css';
import { useLoaderData, useNavigate, useSearchParams } from 'react-router-dom';
import ProductCard from '@/components/ProductCard';
import Pagination from '@/components/Pagination';

const ShopPage = () => {
  const initProductsData = useLoaderData();

  console.log("dd ", initProductsData);

  const data = initProductsData.products.data;

  const { per_page } = initProductsData;

  const [isDown, setIsDown] = useState(false);

  const navigate = useNavigate();

  const [searchParams] = useSearchParams();

  const currentCategory = searchParams.get('category');

  const handleCategoryFilter = category => {
    const params = new URLSearchParams(searchParams);
    params.set('_page', 1);
    params.set('_per_page', per_page);
    if(category) params.set('category', category);
    else params.delete('category');

    navigate(`/shop/?${params}`);
  }

  const handleSort = sortOption => {
    const params = new URLSearchParams(searchParams);

    params.set('_page', 1);
    params.set('_sort', sortOption);
    setIsDown(false);
    navigate(`/shop/?${params}`);
  }

  const sortCase = searchParams.get('_sort');

  const sortTextMap = {
    id : '등록순',
    price : '낮은 가격순',
    '-price' : '높은 가격순',
    discount :'낮은 할인순',
    '-discount' : '높은 할인순'
  };

  const getSortText = () => {
    return sortTextMap[sortCase] || '등록순';
  }

  return (
    <main className={style.shopPage}>
      <h2>ShopPage</h2>
      <div className={style.searchFn}>
        <div className={style.category}>
          <button 
          onClick={() => {
            handleCategoryFilter('');
          }}
          className={currentCategory === null ? style.active : ''}
          >
            전체 상품
          </button>
          <button
            onClick={() => {
              handleCategoryFilter('new');
            }}
            className={currentCategory === 'new' ? style.active : ''}
          >
            신상품
          </button>
          <button
            onClick={() => {
              handleCategoryFilter('top');
            }}
            className={currentCategory === 'top' ? style.active : ''}
            >
            인기상품
          </button>
        </div>
        <div className={`${style.sort} ${isDown ? style.active : ""}`}>
          <div className={style.sortHeader} onClick={() => setIsDown(!isDown)}>
            <p>{getSortText()}</p>
            <i className={`bi bi-chevron-up`}></i>
          </div>
          <ul>
            <li
              onClick={() => {
                handleSort('id');
              }}
              className={sortCase === 'id' ? style.active : ''}
            >
              등록순
            </li>
            <li
              onClick={() => {
                handleSort('price');
              }}
              className={sortCase === 'price' ? style.active : ''}
              >
                낮은 가격순
              </li>
            <li
              onClick={() => {
                handleSort('-price');
              }}
              className={sortCase === '-price' ? style.active : ''}
            >
              높은 가격순
            </li>
            <li
              onClick={() => {
                handleSort('discount');
              }}
              className={sortCase === 'discount' ? style.active : ''}
            >
              낮은 할인순
            </li>
            <li
              onClick={() => {
                handleSort('-discount');
              }}
              className={sortCase === '-discount' ? style.active : ''}
            >
              높은 할인순
            </li>
          </ul>
        </div>
      </div>
      <div className={style.productList}>
        <ul className={style.list}>
          {data.map(product => (
            <ProductCard key={product.id} data={product} />
          ))}
        </ul>
        <Pagination initProductsData={initProductsData} />
      </div>
    </main>
  )
}

export default ShopPage
