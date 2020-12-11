package com.example.reignapp.view.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import com.example.reignapp.R
import com.example.reignapp.core.BaseFragment
import com.example.reignapp.util.KEY_ARGS_STORY_URL
import com.example.reignapp.util.receiveSafeString
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class DetailFragment : BaseFragment<DetailViewModel>() {

    private var urlDestination: String = ""

    override fun getLayoutResource(): Int = R.layout.fragment_detail
    override fun initViewModel(): DetailViewModel = getViewModel()

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupHomeButton(true)
        urlDestination = receiveSafeString(KEY_ARGS_STORY_URL)
        if (urlDestination.isEmpty()) {
            showBackDialog()
        } else {
            val myWebView: WebView = fragment_detail_web_view
            myWebView.webViewClient = MyWebClient()
            myWebView.settings.javaScriptEnabled = true
            myWebView.loadUrl(urlDestination)
        }
    }

    private fun hideLoading() {
        fragment_detail_progress_bar?.visibility = GONE
        fragment_detail_web_view?.visibility = VISIBLE
    }

    private inner class MyWebClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            hideLoading()
            super.onPageFinished(view, url)
        }
    }

    private fun showBackDialog() {
        val dialog = AlertDialog.Builder(requireContext())
                .setTitle(R.string.error)
                .setMessage(R.string.error_msg)
                .setPositiveButton(R.string.back) { view, _ ->
                    requireActivity().onBackPressed()
                    view.dismiss()
                }
                .setCancelable(false)
                .create()
        dialog.show()
    }

}