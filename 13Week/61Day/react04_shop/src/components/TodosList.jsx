import { fetchTodos } from '@/store/todosSlice';
import React, { useEffect } from 'react'
import { Button, ListGroup } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux'

const TodosList = () => {
  const dispatch = useDispatch();
    const { todos, status, error } = useSelector(state => state.todos);

    useEffect(() => {
      dispatch(fetchTodos());
    }, [dispatch]);

    if(status === 'loading') return <p>로딩중...</p>
    if(status === 'failed') return <p>에러가 발생했습니다. {error}</p>

  return todos.length === 0 ? (
    <div>텅~</div>
  ) : (
    <ListGroup className='mt-5'>
        {todos.map(todo => (
            <ListGroup.Item 
                key={todo.id}
                className='d-flex justify-content-between align-items-center'
            >
              <p className='flex-grow-1'>{todo.todoDesc}</p>
              <span style={{fontSize : '0.75em', padding : '1em'}}>{todo.createAt}</span>
              <Button variant="light">삭제</Button>
            </ListGroup.Item>
        ))}
    </ListGroup>
  )
}

export default TodosList