package com.example.tweetsy.data.models


import com.google.gson.annotations.SerializedName

data class Tweet(
    @SerializedName("category")
    val category: String,
    @SerializedName("text")
    val text: String
)