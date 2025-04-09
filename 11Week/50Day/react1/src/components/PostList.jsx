import React from 'react'
import List from './List'

const PostList = ({ listData, setListData }) => {
  return (
    <div className="mw">
      <div className="totalCount">
        <strong>TotalCount</strong>
        <span>{listData.length}</span>
      </div>
      <ul className="postList">
        {listData.map((list, i) => (
          <List key={i} list={list} setListData={setListData} />
        ))}
      </ul>
    </div>
  )
}

export default PostList
