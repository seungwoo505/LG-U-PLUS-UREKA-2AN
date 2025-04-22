import React from 'react'
import style from './Pagination.module.css';
import { useNavigate, useSearchParams } from 'react-router-dom';

const Pagination = ({initProductsData}) => {
    const [searchParams] = useSearchParams();
    const navigate = useNavigate();
    const {first, last, prev, next, pages, items} = initProductsData.products;

    const currentPage = Number(searchParams.get('_page') || 1);

    const handlePageChange = page => {
        const params = new URLSearchParams(searchParams);
        params.set('_page', page);
        navigate(`/shop/?${params}`);
    }

    const getPageNumbers = () => {
        const maxPageNumbers = 10;

        if(pages <= maxPageNumbers){
            return Array.from({length : maxPageNumbers}, (_, i) => i + 1);
        }

        let startPage = Math.max(1, currentPage - Math.floor(maxPageNumbers / 2));
        let endPage = Math.min(pages, startPage + maxPageNumbers - 1);

        if(endPage > pages){
            endPage = pages;
            startPage = Math.max(1, endPage - maxPageNumbers + 1);
        }

        return Array.from({length : endPage - startPage + 1}, (_, i) => i + startPage);
    }

    const pageNumbers = getPageNumbers();

  return (
    <div className={style.paginationArea}>
        <button onClick={() => {
            handlePageChange(1);
        }}
        disabled={currentPage === 1}
        className={currentPage === 1 ? style.disabled : ''}
        >
            처음으로 이동
        </button>
        <button onClick={() => {
            handlePageChange(prev);
        }}
        disabled={prev === null || currentPage === first}
        className={prev === null || currentPage === first ? style.disabled : ''}
        >
            <i className='bi bi-chevron-left'></i>
        </button>
        {
            pageNumbers.map(num => (
                <button key={num} onClick={() => {
                    handlePageChange(num);
                }}
                className={num === currentPage ? style.active : ''}
                >
                    {num}
                </button>
            ))
        }
        <button onClick={() => {
            handlePageChange(next)
        }}
        disabled={next === null || currentPage === last}
        className={next === null || currentPage === last ? style.disabled : ''}
        >
            <i className='bi bi-chevron-right'></i>
        </button>
        <button
            onClick={() => {
                handlePageChange(last);
            }}
            disabled={currentPage === last}
            className={currentPage === last ? style.disabled : ''}
        >
            마지막 페이지 이동
            </button>
    </div>
  )
}

export default Pagination