import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { RouterProvider } from 'react-router-dom'

// Bootstrap CSS 가져오기
import "bootstrap/dist/css/bootstrap.min.css";
// Bootstrap Icons 가져오기
import "bootstrap-icons/font/bootstrap-icons.css";
// Bootstrap JavaScript 가져오기
import "bootstrap/dist/js/bootstrap.bundle.min.js";

import router from './router.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)
