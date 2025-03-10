package com.example.ejmbasicogetpostapi

import com.google.gson.annotations.SerializedName

data class PostModelResponse (

    @SerializedName("userId") var userId: Int,
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("body") var body: String

)