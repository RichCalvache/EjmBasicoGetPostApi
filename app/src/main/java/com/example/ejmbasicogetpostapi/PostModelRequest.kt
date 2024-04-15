package com.example.ejmbasicogetpostapi

import com.google.gson.annotations.SerializedName

data class PostModelRequest (

    @SerializedName("userId") var userId: Int,
    @SerializedName("title") var title: String,
    @SerializedName("body") var body: String

)