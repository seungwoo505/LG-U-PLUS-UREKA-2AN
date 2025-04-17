import { getProductById, getProductsByCategory } from "../api/ProductApi";

export const detailPageLoader = async ({params}) => {
    try {
        const product = await getProductById(params.productId);
        if(!product){
            throw new Response('상품이 존재하지않습니다.', {
                status : 404
            });
        }

        const relatedProducts = await getProductsByCategory(product.category, 10);

        return { product, relatedProducts };
    } catch (error) {
        console.log('err---', error);
    }
}