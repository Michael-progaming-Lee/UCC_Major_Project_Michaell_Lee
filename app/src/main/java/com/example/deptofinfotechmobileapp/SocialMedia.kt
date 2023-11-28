package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class SocialMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        uCCwebload("https://ucconline.ucc.edu.jm/")

        val facebookbtn = findViewById<Button>(R.id.faceBookbtn)
        val twitterbtn = findViewById<Button>(R.id.twitterbtn)
        val instagrambtn = findViewById<Button>(R.id.instagrambtn)

        facebookbtn.setOnClickListener{
            uCCwebload("https://www.facebook.com/profile.php?id=100089819483243")
        }
        twitterbtn.setOnClickListener{
            uCCwebload("https://twitter.com/uccjamaica?s=11")
        }
        instagrambtn.setOnClickListener{
            uCCwebload("https://instagram.com/uccjamaica?igshid=OGQ5ZDc2ODk2ZA==")
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun uCCwebload(website: String) {
        val uucwebview = findViewById<WebView>(R.id.webview)
        uucwebview.settings.javaScriptEnabled = true
        uucwebview.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        uucwebview.webViewClient = WebViewClient()
        uucwebview.loadUrl(website)
    }


}