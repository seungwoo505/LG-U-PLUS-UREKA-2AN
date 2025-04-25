import { configureStore } from "@reduxjs/toolkit";
import { allowanceSlice } from "./allowanceSlice";

export default configureStore({
    reducer : {
        allowance : allowanceSlice.reducer
    }
});