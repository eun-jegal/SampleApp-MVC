package com.example.sampleapp_mvc.data

import com.example.sampleapp_mvc.data.api.APIService
import com.example.sampleapp_mvc.data.model.User

class MainModel(
    private val apiService: APIService
) {
    suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}