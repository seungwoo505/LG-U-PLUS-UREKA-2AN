import React from 'react'

const List = ({ list }) => {
  return (
    <li>
      <p>{list}</p>
      <i class="fa-solid fa-trash-can"></i>
    </li>
  )
}

export default List
