package com.example.ejmbasicogetpostapi

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface PostAPIService {
    @GET("posts")
    suspend fun  getUserPost():ArrayList<PostModelResponse>

    @GET("posts/{id}")
    suspend fun  getUserPostById(@Path("id") id:String):Response<PostModelResponse>

    @Headers("Content-type:application/json; charset=UTF-8")

    @POST("posts")
    suspend fun insertarPublicacion(@Body publicacion:PostModelRequest):Response<PostModelResponse>


    @GET("posts")
    suspend fun  getAllUserPost():ArrayList<PostModelResponse>
}