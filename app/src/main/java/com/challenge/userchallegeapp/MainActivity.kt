package com.challenge.userchallegeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.challenge.userchallegeapp.databinding.ActivityMainBinding
import com.challenge.userchallegeapp.feature.presentation.ui.UserListAdapter
import com.challenge.userchallegeapp.feature.presentation.UserListViewModel
import com.challenge.userchallegeapp.feature.presentation.ui.UserListState
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<UserListViewModel>()
    private val userListAdapter = UserListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.swipeRefreshLayout.isEnabled = false

        with(binding.recyclerView) {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(context)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                when(state) {
                    is UserListState.Loading -> {
                        binding.swipeRefreshLayout.isRefreshing = state.isVisible
                    }
                    is UserListState.OnLoadedUsers -> {
                        userListAdapter.dataSource = state.userList
                    }
                    UserListState.Ilde -> {

                    }
                }
            }
        }
        viewModel.loadUsers()
    }
}