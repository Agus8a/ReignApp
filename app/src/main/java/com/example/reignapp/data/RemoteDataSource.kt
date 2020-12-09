package com.example.reignapp.data


interface RemoteDataSource {
    suspend fun getNews()
}