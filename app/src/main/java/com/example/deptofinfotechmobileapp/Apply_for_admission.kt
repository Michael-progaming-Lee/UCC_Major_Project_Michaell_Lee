package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class Apply_for_admission : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_for_admission)

        admissionApplyWebload("https://ucc.edu.jm/apply/undergraduate/preform")
    }

    private fun admissionApplyWebload(website: String) {
        val applywebview = findViewById<WebView>(R.id.applyWebView)
        applywebview.settings.javaScriptEnabled = true
        applywebview.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        applywebview.webViewClient = WebViewClient()
        applywebview.loadUrl(website)
    }
}