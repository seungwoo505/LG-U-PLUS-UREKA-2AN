import React, { useEffect, useState } from 'react'
import css from './CampingPage.module.css'
import { useCamping } from './useCamping'
import DetailModal from './DetailModal'
import Pagination from './Pagination'

const CampingPage = () => {
  const [isModalOpen, setIsModalOpen] = useState(false)
  const [selected, setSelected] = useState(null)
  const [favorites, setFavorites] = useState(
    localStorage.getItem('favorites') === null ? {} : JSON.parse(localStorage.getItem('favorites'))
  )

  console.log(favorites)

  const [currentPage, setCurrentPage] = useState(1)
  const [perPage, setPerPage] = useState(10)

  const { data, isError, isLoading } = useCamping(currentPage, perPage)

  useEffect(() => {
    console.log(favorites.length)
    localStorage.setItem('favorites', JSON.stringify(favorites))
  }, [favorites])

  if (isError) return <p>에러 발생</p>
  if (isLoading) return <p>Loading...</p>

  const campingData = data.data
  const totalCount = data.totalCount
  const page = data.page

  const handleCampingClick = list => {
    setIsModalOpen(true)
    setSelected(list)
  }

  const closeDetail = () => {
    setIsModalOpen(false)
    setSelected(null)
  }

  const changeFavorites = fav => {
    setFavorites(prev => {
      const newFavorites = { ...prev }
      newFavorites[fav] = prev[fav] === 'solid' ? 'regular' : 'solid'
      return newFavorites
    })
  }

  const calculateTotalPages = () => {
    if (!campingData) return 0
    return Math.ceil(totalCount / perPage)
  }

  const handlePageChange = newPage => {
    setCurrentPage(newPage)
  }

  return (
    <main>
      <h2>CampingPage</h2>
      <div>
        <p>
          총 {totalCount}개 중 {perPage}개 표시 / 현재 {page}page
        </p>
        <ul className={css.list}>
          {campingData.map((list, i) => (
            <div key={list['야영장명'] + i}>
              <i
                className={`${favorites[list['야영장명']] === 'solid' ? 'fa-solid' : 'fa-regular'} fa-star ${css.favorites}`}
                onClick={() => changeFavorites(list['야영장명'])}
              ></i>
              <li onClick={() => handleCampingClick(list)}>
                <p>야영장명 : {list['야영장명']}</p>
                <p>주소 : {list['주소']}</p>
                <p>
                  연락처 : {list['연락처 앞자리']}-{list['연락처 중간자리']}-{list['연락처 끝자리']}
                </p>
              </li>
            </div>
          ))}
        </ul>
      </div>
      <Pagination
        currentPage={currentPage}
        totalPages={calculateTotalPages()}
        onPageChange={handlePageChange}
      />
      {isModalOpen && <DetailModal selected={selected} closeDetail={closeDetail} />}
    </main>
  )
}

export default CampingPage
