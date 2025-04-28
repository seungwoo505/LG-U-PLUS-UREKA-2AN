import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './assets/index.css'
import MainLauout from './layout/MainLauout'
import { RouterProvider } from 'react-router-dom'
import { router } from './router'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router}>
      <MainLauout />
    </RouterProvider>
  </StrictMode>,
)
