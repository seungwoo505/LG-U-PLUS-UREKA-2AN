import axios from 'axios';

const BASE_URL = '/api/products'

export const getProductsData = async (query='') => {
    try{
        const response = await axios.get(`${BASE_URL}/?${query}`);
        
        return response.data;
    }catch(err){
        console.log('err--', err);
    }
}

export const getProductById = async id => {
    try{
        const response = await axios.get(`${BASE_URL}/${id}`);
        
        return response.data;
    }catch(err){
        console.log('err--', err);
    }
}

export const getProductsByCategory = async (category, limit = 10) => {
    try {
        const res = await axios.get(`/api/products/`, {
            params : {
                category,
                _limit : limit
            }
        });

        return res.data;
    } catch (error) {
        console.log("err---", error);
    }
}