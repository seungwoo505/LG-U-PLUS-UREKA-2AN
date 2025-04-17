import axios from 'axios';

const BASE_URL = 'http://localhost:3000/products'

export const getDetailData = async (productId='') => {
    try{
        const response = await axios.get(`${BASE_URL}/${productId}`);
        
        return response.data;
    }catch(err){
        console.log('err--', err);
    }
}