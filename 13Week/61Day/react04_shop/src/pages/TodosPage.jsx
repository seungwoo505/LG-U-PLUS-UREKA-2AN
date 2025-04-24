import TodoInput from '@/components/TodoInput'
import TodoSearch from '@/components/TodoSearch'
import TodosList from '@/components/TodosList'
import React from 'react'

const TodosPage = () => {
  return (
    <main>
        <div>TodosPage</div>
        <TodoSearch />
        <TodoInput />
        <TodosList />
    </main>
  )
}

export default TodosPage