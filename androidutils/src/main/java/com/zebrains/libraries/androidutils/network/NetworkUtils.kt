package com.zebrains.libraries.androidutils.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.zebrains.libraries.androidutils.Const.MOBILE
import com.zebrains.libraries.androidutils.Const.WIFI

//TODO: Посмотреть, как можно сократить запись и выделить в отдельную функцию

fun Context.isNetworkConnected(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) ?: return false
    return when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        else -> false
    }
}

fun Context.getNetworkType(): String {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) ?: return ""
    return when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> WIFI
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> MOBILE
        else -> ""
    }
}