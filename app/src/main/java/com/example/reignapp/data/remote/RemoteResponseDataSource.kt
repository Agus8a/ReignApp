package com.example.reignapp.data.remote

import com.example.reignapp.data.RemoteDataSource
import com.example.reignapp.data.remote.response.HackerNewsResponse

class RemoteResponseDataSource(
    private val api: ApiService
) : RemoteDataSource {
    override suspend fun getNews(): HackerNewsResponse {
        var hackerNewsResponse = HackerNewsResponse()
        try {
            hackerNewsResponse = api.getHackerNews()
        } catch (e: Exception) {
        }

        return hackerNewsResponse
    }
}