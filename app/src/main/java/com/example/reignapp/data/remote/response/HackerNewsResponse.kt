package com.example.reignapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class HackerNewsResponse(
    @SerializedName("hits") val hits: List<Hit> = listOf(),
    @SerializedName("nbHits") val nbHits: Int = 0,
    @SerializedName("page") val page: Int = 0,
    @SerializedName("nbPages") val nbPages: Int = 0,
    @SerializedName("hitsPerPage") val hitsPerPage: Int = 0,
    @SerializedName("exhaustiveNbHits") val exhaustiveNbHits: Boolean = false,
    @SerializedName("query") val query: String = "",
    @SerializedName("params") val params: String = "",
    @SerializedName("processingTimeMS") val processingTimeMS: Int = 0
)