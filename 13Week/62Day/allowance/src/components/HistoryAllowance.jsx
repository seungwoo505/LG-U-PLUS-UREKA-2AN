import React from 'react'
import { useSelector, useDispatch } from 'react-redux';
import { removeAllowance } from '../store/allowanceSlice';
import './history.css';

const HistoryAllowance = () => {
    const { allowance } = useSelector(state => state.allowance);
    const dispatch = useDispatch();
    const handleDelete = (index) => {
      dispatch(removeAllowance(index));
    };
  return (
    <div className="history-allowance-container">
        <h2 className="history-title">내역</h2>
        {allowance.map((allowance) => (
            <div key={allowance.id} className="history-item">
                <p className="history-title-text">{allowance.title}</p>
                <p
                  className={`history-money-text ${
                    allowance.type === 'expenditure' ? 'expenditure' : 'income'
                  }`}
                >
                  {`${allowance.type === "expenditure" ? "-" : ""}${allowance.money.toLocaleString('ko-KR')}`}
                </p>
                <i
                  className="fa-solid fa-trash history-delete-icon"
                  onClick={() => handleDelete(allowance.id)}
                />
            </div>
        ))}
    </div>
  )
}

export default HistoryAllowance;