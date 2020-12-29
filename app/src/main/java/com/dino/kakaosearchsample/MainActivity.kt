package com.dino.kakaosearchsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dino.kakao.search.kakaoSearchClient
import com.google.gson.Gson
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val kakaoSearchClient by kakaoSearchClient("44bfc2b46deeda3044c4303a17db28ee")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            val response = kakaoSearchClient.searchWeb("안드로이드")
            Log.e("dino_log", Gson().toJson(response))
        }
    }
}
