import React, { useEffect, useState } from 'react'
import { useSelector } from 'react-redux'
import './total.css';

const TotalAllowance = () => {
    const { allowance } = useSelector(state => state.allowance);
    const [income, setIncome] = useState(0);
    const [expenditure, setExpenditure] = useState(0);
    const balance = income - expenditure;

    useEffect(() => {
        setIncome(0);
        setExpenditure(0);

        allowance.map((a) => {
            if(a.type === "income") setIncome((prev) => prev + a.money);
            else setExpenditure((prev) => prev + a.money);
        });
    }, [allowance]);
  return (
    <div className="total-allowance-container">
        <div className="balance-section">
            <h2>잔액</h2>
            <p className={balance >= 0 ? 'balance-positive' : 'balance-negative'}>
              {balance.toLocaleString('ko-KR')}
            </p>
        </div>
        <div className="summary-section">
            <div className="income-box">
                <h2>수입</h2>
                <p>{income.toLocaleString('ko-KR')}</p>
            </div>
            <div className="expenditure-box">
                <h2>지출</h2>
                <p>{expenditure.toLocaleString('ko-KR')}</p>
            </div>
        </div>
    </div>
  )
}

export default TotalAllowance