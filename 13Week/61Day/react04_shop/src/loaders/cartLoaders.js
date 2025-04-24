import {getCartData} from '../api/cartApi';

export const cartPageLoader = async () => {
    try {
        const cartItems = await getCartData();

        if(!cartItems || cartItems.length === 0){
            return {cartItems : []};
        }
        return cartItems;
    } catch (error) {
        console.error('err---', error);
    }
}