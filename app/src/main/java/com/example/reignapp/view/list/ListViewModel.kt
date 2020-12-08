package com.example.reignapp.view.list

import androidx.lifecycle.ViewModel
import com.example.reignapp.data.RemoteDataSource

class ListViewModel(
    private val remoteDataSource: RemoteDataSource
) : ViewModel() {
    suspend fun getNews() {
        remoteDataSource.getNews()
    }

}