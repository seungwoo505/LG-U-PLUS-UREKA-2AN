import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import css from './LatestList.module.css'
import ProductCard from '../components/ProductCard'
import { getProductsData } from '../api/productsApi'
import ProductCardSkeleton from '@/components/ProductCardSkeleton'

const delay = ms => new Promise(resolve => setTimeout(resolve, ms))

const LatestList = () => {
  const [products, setProducts] = useState([])
  const [loading, setLoading] = useState(false)
  const [pCount, setPCount] = useState(6)

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        setLoading(true)
        await delay(30)
        const data = await getProductsData(`category=new&_limit=${pCount}`)
        console.log('data----', data)

        setProducts(data)
        setLoading(false)
      } catch (err) {
        console.log(err)
        setLoading(false)
      }
    }

    fetchProducts()
  }, [pCount])

  const skeletonArr = Array(pCount).fill(null)
  return (
    <section className={css.listCon}>
      <h2>Shop The Latest</h2>
      <Link to={'/shop'} className={css.more}>
        View All
      </Link>
      <div className={css.select}>
        옵션:
        <select
          name="productCoun"
          id="productCoun"
          value={pCount}
          onChange={e => setPCount(Number(e.target.value))}
        >
          <option value="2">2개씩</option>
          <option value="4">4개씩</option>
          <option value="6">6개씩</option>
          <option value="8">8개씩</option>
        </select>
      </div>
      <ul className={css.list}>
        {loading
          ? skeletonArr.map((_, i) => (
              <li key={i}>
                <ProductCardSkeleton />
              </li>
            ))
          : products.map(data => (
              <li key={data.id}>
                <ProductCard data={data} />
              </li>
            ))}
      </ul>
    </section>
  )
}

export default LatestList
