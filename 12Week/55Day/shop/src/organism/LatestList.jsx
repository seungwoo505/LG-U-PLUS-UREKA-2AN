import React, { useEffect, useState } from 'react'
import {Link} from 'react-router-dom';
import style from './LatestList.module.css'
import ProductCard from '../components/ProductCard';
import { getProductsData } from '../api/ProductApi';

const LatestList = () => {
    const [product, setProduct] = useState([]);
    useEffect(()=> {
        const fetchProducts = async () => {
            try {
                const data = await getProductsData('category=new&_limit=6');
                setProduct(data);
            } catch (error) {
                console.log(error);
            }
        }

        fetchProducts();
    }, []);
  return (
    <section className={style.listCon}>
        <h2>Shop The Latest</h2>
        <Link to={'/shop'} className={style.more}>View All</Link>
        <ul className={style.list}>
            {
                product.map(data => (
                    <li key={data.id}>
                        <ProductCard data={data}/>
                    </li>
                ))
            }
        </ul>
    </section>
  )
}

export default LatestList