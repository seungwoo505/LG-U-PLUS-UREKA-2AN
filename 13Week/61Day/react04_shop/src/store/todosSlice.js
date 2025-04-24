import { getTodosData } from "@/api/todosApi";
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

// const todos = [
//     {
//         id : 1,
//         todosDesc : '할일 내용이 입력되는 곳',
//         createAt : '2025.04.24',
//         isDone : false
//     },
//     {
//         id : 2,
//         todosDesc : '22할일 내용이 입력되는 곳22',
//         createAt : '2025.04.25',
//         isDone : false
//     }
// ];
export const fetchTodos = createAsyncThunk('todos/fetchTodos', async () => {
    const res = await getTodosData();

    return res;
})
export const todosSlice = createSlice({
    name : 'todos',
    initialState : {
        todos : [],
        status : 'idle',
        error : null
    },
    reducers : {

    },
    extraReducers : builder => {
        return builder
            .addCase(fetchTodos.pending, state => {
                state.status = 'loading';
                state.error = null;
            })
            .addCase(fetchTodos.fulfilled, (state, action) => {
                state.status = 'success';
                state.todos = action.payload;
                state.error = null;
            })
            .addCase(fetchTodos.rejected, (state, action) => {
                state.status = 'failed';
                state.error = action.error.message;
            })
    }
});