package com.example.reignapp.di

import com.example.reignapp.view.list.ListViewModel
import com.example.reignapp.view.main.MainViewModel
import com.example.reignapp.view.webview.WebViewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel() }
    viewModel { ListViewModel() }
    viewModel { WebViewViewModel() }
}