import React from 'react'
import css from './DetailModal.module.css'

const DetailModal = ({ selected, closeDetail }) => {
  console.log('selected:', selected)

  return (
    <div className={css.modal}>
      <div className={css.modalContent}>
        <h2>상세정보</h2>
        <p>야영장 명 : {selected['야영장명']}</p>
        <p>주소 : {selected['주소']}</p>
        <p>
          연락처 : {selected['연락처 앞자리']}-{selected['연락처 중간자리']}-
          {selected['연락처 끝자리']}
        </p>
        <p>인허가일자 : {selected['인허가일자']}</p>
        <p>부대시설 : {selected['부대시설']}</p>
        <p>주변이용가능시설 : {selected['주변이용가능시설']}</p>
        <button onClick={closeDetail}>닫기</button>
      </div>
    </div>
  )
}

export default DetailModal
