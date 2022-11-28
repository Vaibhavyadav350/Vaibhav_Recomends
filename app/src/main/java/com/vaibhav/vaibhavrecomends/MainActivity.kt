package com.vaibhav.vaibhavrecomends

import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val mywebView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mwebView = findViewById<View>(R.id.webview) as WebView
        mwebView.loadUrl("https://vaibhav-recommends.herokuapp.com/")

        val webSettings = mwebView.settings
        webSettings.javaScriptEnabled = true
        mwebView.webViewClient= WebViewClient()

        mwebView.canGoBack()
        mwebView.setOnKeyListener(View.OnKeyListener{v, keyCode, event ->

            if(keyCode==KeyEvent.KEYCODE_BACK

                && event.action ==MotionEvent.ACTION_UP
                && mwebView.canGoBack()) {
                mwebView.goBack()
                return@OnKeyListener true
            }
            false
        })

    }
}