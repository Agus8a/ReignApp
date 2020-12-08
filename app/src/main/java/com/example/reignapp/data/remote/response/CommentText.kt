package com.example.reignapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class CommentText(
    @SerializedName("value") val value: String,
    @SerializedName("matchLevel") val matchLevel: String,
    @SerializedName("fullyHighlighted") val fullyHighlighted: Boolean,
    @SerializedName("matchedWords") val matchedWords: List<String>
)

