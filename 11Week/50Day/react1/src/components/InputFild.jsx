import React, { useState } from 'react'

const InputFild = ({ setListData }) => {
  const [inputText, setInputText] = useState('')

  const inputItem = e => {
    setInputText(e.target.value)
  }

  const addItem = () => {
    /*
    if (inputText.trim() === '') {
      alert('여행지를 입력하세요')
      document.querySelector('input').focus()
      return
    } else if (inputText.trim().length < 2) {
      alert('2자 이상 입력해주세요.')
      document.querySelector('input').focus()
      return
    }
      */

    if (inputText.trim().length < 2) {
      alert(inputText.trim() === '' ? '여행지를 입력하세요' : '2자 이상 입력해주세요')
      document.querySelector('input').focus()
      return
    }

    setListData(prev => {
      const input = [inputText.trim(), ...prev]
      localStorage.setItem('list', JSON.stringify(input))

      return input
    })
    setInputText('')
    document.querySelector('input').focus()
  }

  const handleKeyUp = e => {
    if (e.key === 'Enter') addItem()
  }
  return (
    <div className="inputFild mw">
      <input
        type="text"
        placeholder="여행지를 입력해주세요"
        onChange={inputItem}
        onKeyUp={handleKeyUp}
        value={inputText}
      />
      <button onClick={addItem}>입력</button>
    </div>
  )
}

export default InputFild
