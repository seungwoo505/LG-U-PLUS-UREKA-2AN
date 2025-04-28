import React, { useEffect } from 'react'
import { useSelector, useDispatch } from 'react-redux';
import { initAllowance, removeAllowance } from '../store/allowanceSlice';
import './history.css';
import { useGetAllowanceQuery } from '../api/allowanceApi';

const HistoryAllowance = () => {
    const { allowance } = useSelector(state => state.allowance);
    const dispatch = useDispatch();

    const { data, error, isLoading } = useGetAllowanceQuery();
    const handleDelete = (index) => {
      dispatch(removeAllowance(index));
    };

    useEffect(() => {
      if(data === undefined || data === null ) return;
      dispatch(initAllowance(data));
    }, [data, allowance]);
  return (
    <div className="history-allowance-container">
        <h2 className="history-title">내역</h2>
        {error ? (
          <>에러가 발생했습니다.</>
        ) : isLoading ? (
          <>로딩 중...</>
        ) : data ? 
        allowance.map((allowance) => (
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
        )) : (
          <>데이터 없음</>
        )
      }
    </div>
  )
}

export default HistoryAllowance;