package com.example.reignapp.di

import com.example.reignapp.data.RemoteDataSource
import com.example.reignapp.data.local.db.ReignDatabase
import com.example.reignapp.data.remote.ApiProvider
import com.example.reignapp.data.remote.RemoteResponseDataSource
import com.example.reignapp.view.list.ListViewModel
import com.example.reignapp.view.main.MainViewModel
import com.example.reignapp.view.webview.WebViewViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel() }
    viewModel { ListViewModel(get()) }
    viewModel { WebViewViewModel() }

    single<RemoteDataSource> { RemoteResponseDataSource(get()) }

    single { ApiProvider() }
    single {
        val apiProvider: ApiProvider = get()
        apiProvider.api
    }
    single { ReignDatabase.getAppDatabase(androidContext()) }
}