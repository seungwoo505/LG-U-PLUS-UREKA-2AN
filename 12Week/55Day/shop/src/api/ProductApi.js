import axios from 'axios';

const BASE_URL = 'http://localhost:3000/products'

export const getProductsData = async (query='') => {
    try{
        const response = await axios.get(`${BASE_URL}/?${query}`);
        
        return response.data;
    }catch(err){
        console.log('err--', err);
    }
}