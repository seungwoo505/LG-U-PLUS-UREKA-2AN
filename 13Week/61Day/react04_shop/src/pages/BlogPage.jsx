import Counter from '@/components/Counter'
import { decrement, increment, resetment } from '@/store/counterSlice';
import React from 'react'
import { useDispatch } from 'react-redux'

const BlogPage = () => {
  const dispatch = useDispatch();

  const increse = (num = 1) => {
    dispatch(increment(num));
  }

  const decrese = () => {
    dispatch(decrement());
  }

  const reset = () => {
    dispatch(resetment());
  }
  return (
    <main>
      <h2>BlogPage</h2>
      <Counter />
      <Counter />
      <Counter />
      <button onClick={() => increse()}>증가하기</button>
      <button onClick={() => increse(10)}>증가하기(10)</button>
      <button onClick={decrese}>감소하기</button>
      <button onClick={reset}>초기화</button>
    </main>
  )
}

export default BlogPage
