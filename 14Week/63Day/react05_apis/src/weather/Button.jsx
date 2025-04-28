import React from 'react'

const Button = ({city, label, onClick}) => {
  return (
    <button onClick={() => onClick(city)} style={{padding : '1rem', border : '1px solid gray'}}>
        {label}
    </button>
  )
}

export default Button