import axios from 'axios'
axios.defaults.withCredentials = true // 모든 요청에 대해 withCredentials 설정
const API_URL = import.meta.env.VITE_BACK_URL;

export const getUserProfile = async () => {
  try {
    const res = await axios.get(`${API_URL}/profile`)
    return res
  } catch (err) {
    console.error(err)
    throw err // 에러를 호출한 곳으로 전달
  }
}

export const loginUser = async credentials => {
  const response = await axios.post(`${API_URL}/login`, credentials)
  return response
}

export const registerUser = async userData => {
  const response = await axios.post(`${API_URL}/register`, userData)
  return response
}

export const logoutUser = async () => {
    const res = await axios.post(`${API_URL}/logout`);
    return res;
}