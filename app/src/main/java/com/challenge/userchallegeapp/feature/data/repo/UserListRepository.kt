package com.challenge.userchallegeapp.feature.data.repo

import com.challenge.userchallegeapp.feature.data.model.User

interface UserListRepository {
    suspend fun requestUsers(): List<User>
}