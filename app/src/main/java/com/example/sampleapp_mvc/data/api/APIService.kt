package com.example.sampleapp_mvc.data.api

import com.example.sampleapp_mvc.data.model.User
import retrofit2.http.GET

interface APIService {
    @GET("users")
    suspend fun getUsers(): List<User>
}