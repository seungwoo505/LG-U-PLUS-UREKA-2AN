import React from 'react'
import { useSelector } from 'react-redux';

const Counter = () => {
    const {count, label} = useSelector( state => state.counter);
  return (
    <p>
        {count} : {label}
    </p>
  )
}

export default Counter