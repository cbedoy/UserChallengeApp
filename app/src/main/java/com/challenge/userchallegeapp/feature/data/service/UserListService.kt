package com.challenge.userchallegeapp.feature.data.service

import com.challenge.userchallegeapp.feature.data.dto.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserListService {
    @GET("users")
    suspend fun getUsers(): Response<List<UserResponse>>
}