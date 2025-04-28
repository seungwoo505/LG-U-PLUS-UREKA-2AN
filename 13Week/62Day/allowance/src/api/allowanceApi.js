import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const allowanceApi = createApi({
    reducerPath : 'allowanceApi',
    baseQuery : fetchBaseQuery({baseUrl : 'http://localhost:3000/'}),
    endpoints : (builder) => ({
        getAllowance : builder.query({
            query : () => ({url : 'allowance'})
        })
    })
});

export const { useGetAllowanceQuery } = allowanceApi;