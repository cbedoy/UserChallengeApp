package com.challenge.userchallegeapp.feature.module

import com.challenge.userchallegeapp.feature.data.repo.UserListRepository
import com.challenge.userchallegeapp.feature.data.service.UserListService
import com.challenge.userchallegeapp.feature.data.repo.UserListRepositoryImpl
import com.challenge.userchallegeapp.feature.domain.UserListUseCase
import com.challenge.userchallegeapp.feature.presentation.UserListViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

private val jsonConfiguration = Json {
    ignoreUnknownKeys = true
}

val userListModule = module {

    fun <T> provideService(retrofit: Retrofit, clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(jsonConfiguration.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    viewModel {
        UserListViewModel(
            useCase = get()
        )
    }

    factory {
        UserListUseCase(
            repository = get()
        )
    }

    factory<UserListRepository> {
        UserListRepositoryImpl(
            service = get()
        )
    }


    single { provideRetrofit() }
    single { provideService(get(), UserListService::class.java) }
}