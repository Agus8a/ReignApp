package com.example.reignapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class StoryUrlResponse(
    @SerializedName("value") val value: String,
    @SerializedName("matchLevel") val matchLevel: String,
    @SerializedName("matchedWords") val matchedWords: List<String>
)

