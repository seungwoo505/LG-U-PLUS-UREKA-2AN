import React from 'react'
import List from './List'

const PostList = ({ listData, data }) => {
  console.log(listData)
  console.log(data)
  return (
    <div className="mw">
      <div className="totalCount">
        <strong>TotalCount</strong>
        <span>{listData.length}</span>
      </div>
      <ul className="postList">
        {listData.map((list, i) => (
          <List key={i} list={list} />
        ))}
      </ul>
    </div>
  )
}

export default PostList
