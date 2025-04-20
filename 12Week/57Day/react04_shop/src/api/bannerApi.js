import axios from 'axios'
const BASE_URL = 'http://localhost:3000/banners/'

export const getBannerData = async () => {
  try {
    const res = await axios.get(`${BASE_URL}`)
    // console.log('res----', res)
    return res.data
  } catch (err) {
    console.log('err----', err)
    // throw err
  }
}
