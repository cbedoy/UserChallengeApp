package com.challenge.userchallegeapp.feature.data.repo

import com.challenge.userchallegeapp.feature.data.model.User
import com.challenge.userchallegeapp.feature.data.service.UserListService

class UserListRepositoryImpl (private val service: UserListService): UserListRepository {

    override suspend fun requestUsers(): List<User> {
        val response = service.getUsers()
        return if (response.isSuccessful) {
            return response.body()?.map {
                User(mail = it.email?:"", name = it.name?:"")
            }?: emptyList()
        } else {
            emptyList()
        }
    }
}