package com.dino.kakaosearchsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dino.kakao.search.kakaoSearchClient
import com.dino.kakao.search.model.KakaoImageResponse
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val kakaoSearchClient by kakaoSearchClient("44bfc2b46deeda3044c4303a17db28ee")

    private var page = 1

    val query = MutableLiveData<String>()

    private val _images = MutableLiveData<List<KakaoImageResponse>>()
    val images: LiveData<List<KakaoImageResponse>> = _images

    fun search() {
        Log.e("dino_log", "search")
        viewModelScope.launch {
            val query = query.value ?: return@launch
            val response = kakaoSearchClient.searchImage(query, page = page)

            val list = mutableListOf<KakaoImageResponse>()
            list.addAll(response.documents)
            _images.value = list
        }
    }

    fun loadMore() {
        Log.e("dino_log", "loadMore")
        viewModelScope.launch {
            val query = query.value ?: return@launch
            page++
            val response = kakaoSearchClient.searchImage(query, page = page)

            val list = images.value?.toMutableList()
            list?.addAll(response.documents)
            _images.value = list
        }
    }


}
