import mongoose from "mongoose";

const { Schema, model } = mongoose;

const userSchema = new Schema({
    userName : {
        type : String,
        require : true,
        unique : true
    },

    password : {
        type : String,
        required : true
    }
});

export const userModel = model("User", userSchema);