package com.example.reignapp.data

import com.example.reignapp.data.remote.response.HackerNewsResponse

interface RemoteDataSource {
    suspend fun getNews(): HackerNewsResponse
}