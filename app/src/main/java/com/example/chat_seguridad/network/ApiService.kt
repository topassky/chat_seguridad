package com.example.chat_seguridad.network

import com.example.chat_seguridad.data.model.LoginResponse
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Field

interface ApiService {
    @FormUrlEncoded
    @POST("api/auth/")
    suspend fun loginUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): LoginResponse
}