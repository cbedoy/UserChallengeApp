package com.challenge.userchallegeapp.feature.presentation.ui

import com.challenge.userchallegeapp.feature.data.model.User

sealed class UserListState {
    object Ilde: UserListState()
    data class Loading(val isVisible: Boolean): UserListState()
    data class OnLoadedUsers(val userList: List<User>): UserListState()
}