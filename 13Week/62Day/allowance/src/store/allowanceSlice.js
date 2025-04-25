import { createSlice } from "@reduxjs/toolkit";

export const allowanceSlice = createSlice({
    name : 'allowance',
    initialState : {
        allowance : [],
        label : "용돈"
    },
    reducers : {
        addAllowance : (state, action) => {
            action.payload.id = state.allowance.length;
            state.allowance = [...state.allowance, action.payload];
        },

        removeAllowance : (state, action) => {
            state.allowance = state.allowance.filter(money => money.id !== action.payload);
        },

        initAllowance : (state, action) => {
            state.allowance = action.payload;
        }
    }
});

export const {addAllowance, removeAllowance, initAllowance} = allowanceSlice.actions;