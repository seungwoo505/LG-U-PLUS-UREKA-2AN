import { model, Schema } from "mongoose";

const postSchema = new Schema({
    title : {
        type : String,
        required : true
    },
    summary : {
        type : String,
        required : true
    },
    content : {
        type : String,
        required : true
    },
    cover : {
        type : String,
        required : false
    },
    author : {
        type : String,
        required : true
    }
},{
    timestamps : true
});

export const postModel = model("Post", postSchema);