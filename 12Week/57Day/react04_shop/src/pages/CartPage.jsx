import React from 'react'
import { useLoaderData } from 'react-router-dom'

const CartPage = () => {
  const cartList = useLoaderData();
  console.log(cartList);
  return (
    <main>
      <h2>CartPage</h2>
    </main>
  )
}

export default CartPage
