import React from 'react'
import { Button, Form, InputGroup } from 'react-bootstrap'

const TodoSearch = () => {
  return (
    <InputGroup>
      <Form.Control placeholder="검색어를 입력하세요" aria-label="검색어 입력 요소" />
      <Button variant="outline-secondary">검색하기</Button>
      <Button variant="outline-secondary">초기화</Button>
    </InputGroup>
  )
};

export default TodoSearch;