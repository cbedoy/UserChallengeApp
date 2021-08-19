package com.challenge.userchallegeapp.feature.domain

import com.challenge.userchallegeapp.feature.data.repo.UserListRepository
import com.challenge.userchallegeapp.feature.presentation.ui.UserListState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserListUseCase(private val repository: UserListRepository) {

     fun loadUserList() = flow {
         emit(UserListState.Loading(isVisible = true))

         val users = repository.requestUsers()

         emit(UserListState.OnLoadedUsers(userList = users))

         emit(UserListState.Loading(isVisible = false))
         emit(UserListState.Ilde)
     }.flowOn(
         Dispatchers.IO
     )
}