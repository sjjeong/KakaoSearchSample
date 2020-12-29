package com.dino.kakao.search.model


import com.google.gson.annotations.SerializedName

data class KakaoCafeResponse(
    @SerializedName("cafename")
    val cafeName: String,
    @SerializedName("contents")
    val contents: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
)