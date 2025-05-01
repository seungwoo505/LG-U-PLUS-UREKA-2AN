import axios from 'axios'
axios.defaults.withCredentials = true // 모든 요청에 대해 withCredentials 설정
const API_URL = import.meta.env.VITE_BACK_URL;

export const createPostApi = async (postData) => {
    const response = await axios.post(`${API_URL}/postWrite`, postData, {
        headers : {
            'Content-Type' : 'multipart/form-data'
        }
    });

    return response.data;
}