package com.zebrains.libraries.androidutils.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

inline fun <reified T : Any> Context.navigateToActivity(noinline init: Intent.() -> Unit) {
    val intent = Intent(this, T::class.java).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }
    intent.init()
    startActivity(intent)
}

fun Activity.setFullScreen() {
    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

fun Activity.showToolbar() {
    actionBar?.show()
}

fun Activity.hideToolbar() {
    actionBar?.hide()
}

fun AppCompatActivity.showToolbar() {
    supportActionBar?.show()
}

fun AppCompatActivity.hideToolbar() {
    supportActionBar?.hide()
}