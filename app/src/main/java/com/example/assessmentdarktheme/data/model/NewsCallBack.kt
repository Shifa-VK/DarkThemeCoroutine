package com.example.assessmentdarktheme.data.model


import com.google.gson.annotations.SerializedName

data class NewsCallBack(
    @SerializedName("articles")
    var articles: List<Article>,
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int
)