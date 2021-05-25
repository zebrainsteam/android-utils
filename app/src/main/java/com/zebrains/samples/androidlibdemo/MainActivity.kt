package com.zebrains.samples.androidlibdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zebrains.libraries.androidutils.AndroidUtilsMain
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialise the main class from the Sample Android Library module
        val androidUtilsMain = AndroidUtilsMain()
        tv_welcome.text = androidUtilsMain.welcomeString
    }
}
