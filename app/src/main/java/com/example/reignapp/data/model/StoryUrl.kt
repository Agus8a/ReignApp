package com.example.reignapp.data.model

data class StoryUrl(
        val id: Long = 0L,
        var hitId: Long = 0L,
        val value: String? = "",
        val matchLevel: String? = "",
        val matchedWords: String? = ""
)