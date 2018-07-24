package com.example.msi_gl62.simpelapp.testwebview

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.msi_gl62.simpelapp.R
import kotlinx.android.synthetic.main.activity_testwebview.*

class testwebview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testwebview)
        test()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun test() {
        webView.getSettings().setJavaScriptEnabled(true)
        webView.loadUrl("http://demo.appedr.com:8088/edr_android/parentDashboard?_studentId=4569")
        webView.webViewClient = WebViewClient()
    }
}
