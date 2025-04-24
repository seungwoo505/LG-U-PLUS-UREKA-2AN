import React from 'react'
import { Button, Form, InputGroup } from 'react-bootstrap'

const TodoInput = () => {
  return (
    <InputGroup className='mt-5 mb-5'>
        <Form.Control as="textarea" aria-label="With textarea" />
        <Button variant='outline-secondary'>할일등록</Button>
      </InputGroup>
  )
}

export default TodoInput