import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addAllowance } from '../store/allowanceSlice';
import './input.css';

const InputAllowance = () => {
    const [title, setTitle] = useState('');
    const [money, setMoney] = useState('0');
    const [type, setType] = useState(null);
    const dispatch = useDispatch();

    const add = (e) => {
        e.preventDefault();
        if(title !== '' && money !== '0' && type !== null) {
            dispatch(addAllowance({title, money, type}));
            setTitle('');
            setMoney('0');
            setType(null);
        }
        else alert("일부를 입력하지않으셨습니다.");
    }
  return (
    <div className="input-allowance-container">
      <form>
          <h2 className="form-title">새로운 거래 추가</h2>
          <p className="form-description">텍스트</p>
          <input
              className="input-title"
              type='text'
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              placeholder='내용입력...'
              required
          />
          <div className="input-radio-group">
            <label className="input-radio">
              <input 
                  type='radio' 
                  name='allowance' 
                  value='income'
                  checked={type === 'income'}
                  onChange={() => setType('income')}
                  required
              /> 수입
            </label>
            <label className="input-radio">
              <input 
                  type='radio' 
                  name='allowance' 
                  value='expenditure'
                  checked={type === 'expenditure'}
                  onChange={() => setType('expenditure')}
                  required
              /> 지출
            </label>
          </div>
          <input 
              className="input-money"
              type="text"
              value={money.toLocaleString('ko-KR')}
              maxLength={20}
              onChange={(money) => setMoney(Number(money.target.value.replace(/[^0-9]/g, '')))}
              required
          />
          <input type='submit' className="submit-button" onClick={add} value="추가하기"/>
      </form>
    </div>
  )
}

export default InputAllowance