import { configureStore } from "@reduxjs/toolkit";
import { allowanceSlice } from "./allowanceSlice";
import { setupListeners } from "@reduxjs/toolkit/query";
import { allowanceApi } from "../api/allowanceApi";

export const store = configureStore({
    reducer : {
        allowance : allowanceSlice.reducer,
        [allowanceApi.reducerPath] : allowanceApi.reducer
    },

    middleware : (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(allowanceApi.middleware)
});

setupListeners(store.dispatch);