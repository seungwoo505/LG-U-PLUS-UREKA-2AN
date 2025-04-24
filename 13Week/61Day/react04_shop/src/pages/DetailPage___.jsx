import { getProductById } from '@/api/productsApi'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

const DetailPage = () => {
  const { productId } = useParams()
  console.log('test--', productId)

  const [product, setProduct] = useState({})
  useEffect(() => {
    const fetchProduct = async () => {
      try {
        const res = await getProductById(productId)
        setProduct(res)
      } catch (err) {
        console.log('err--', err)
      }
    }
    fetchProduct()
  }, [productId])

  return (
    <main>
      <h2>DetailPage</h2>
      <p>{product.title}</p>
    </main>
  )
}

export default DetailPage
