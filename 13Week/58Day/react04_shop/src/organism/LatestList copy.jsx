import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import css from './LatestList.module.css'
import ProductCard from '../components/ProductCard'
import { getProductsData } from '../api/productsApi'

const LatestList = () => {
  const [products, setProducts] = useState([])
  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const data = await getProductsData(`category=new&_limit=6`)
        console.log('data----', data)

        setProducts(data)
      } catch (err) {
        console.log('err----', err)
      }
    }

    fetchProducts()
  }, [])

  return (
    <section className={css.listCon}>
      <h2>Shop The Latest</h2>
      <Link to={'/shop'} className={css.more}>
        View All
      </Link>
      <ul className={css.list}>
        {products.map(data => (
          <li key={data.id}>
            <ProductCard data={data} />
          </li>
        ))}
      </ul>
    </section>
  )
}

export default LatestList
