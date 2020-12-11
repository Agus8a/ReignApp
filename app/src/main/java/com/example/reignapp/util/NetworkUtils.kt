@file:Suppress("DEPRECATION")

package com.example.reignapp.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun isConnectedToInternet(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    return activeNetwork?.isConnected == true
}
