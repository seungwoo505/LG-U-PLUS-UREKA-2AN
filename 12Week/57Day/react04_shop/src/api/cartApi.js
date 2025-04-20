import axios from 'axios';

export const getCartData = async () => {
    try{
        const res = await axios.get('/api/cart/');
        console.log('getCart : ', res);
        return res.data;
    }catch(err){
        console.log("err------", err);
    }
}

export const addToCart = async cartItem => {
    try {
        const cart = await getCartData();
        const existingItem = cart.find(item => item.id === cartItem.id);

        if(existingItem){
            const updateItem = {
                ...existingItem,
                count : existingItem.count + cartItem.count
            };

            const res = await axios.put(`/api/cart/${existingItem.id}`, updateItem);
            return res.data;
        }else{
            const res = await axios.post('/api/cart/', cartItem);
            return res.data;
        }
    } catch (error) {
        console.error('err--', error);
    }
}