import React from 'react'

const List = ({ list, setListData }) => {
  const removeItem = () => {
    setListData(prev => {
      const newData = prev.filter(item => item !== list)
      localStorage.setItem('list', JSON.stringify(newData))
      return newData
    })
  }
  return (
    <li>
      <p>{list}</p>
      <i className="fa-solid fa-trash-can" onClick={removeItem}></i>
    </li>
  )
}

export default List
