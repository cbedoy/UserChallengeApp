package com.challenge.userchallegeapp.feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.userchallegeapp.feature.domain.UserListUseCase
import com.challenge.userchallegeapp.feature.presentation.ui.UserListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserListViewModel(
    private val useCase: UserListUseCase
): ViewModel(){

    private val _state = MutableStateFlow<UserListState>(UserListState.Ilde)
    val state: StateFlow<UserListState>
        get() = _state

   fun loadUsers() {
       viewModelScope.launch {
           useCase.loadUserList().collect {
               _state.emit(it)
           }
       }
   }
}