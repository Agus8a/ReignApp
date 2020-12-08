package com.example.reignapp.view.webview

import com.example.reignapp.R
import com.example.reignapp.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class WebViewFragment : BaseFragment<WebViewViewModel>() {

    override fun getLayoutResource(): Int = R.layout.fragment_web_view
    override fun initViewModel(): WebViewViewModel = getViewModel()

}