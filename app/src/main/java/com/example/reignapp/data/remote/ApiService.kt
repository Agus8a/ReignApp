package com.example.reignapp.data.remote

import com.example.reignapp.data.remote.response.HackerNewsResponse
import com.example.reignapp.util.SEARCH_ENDPOINT
import retrofit2.http.GET

interface ApiService {
    @GET(SEARCH_ENDPOINT)
    suspend fun getHackerNews(): HackerNewsResponse
}