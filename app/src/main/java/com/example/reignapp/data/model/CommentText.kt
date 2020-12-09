package com.example.reignapp.data.model

data class CommentText(
        val id: Long = 0L,
        var hitId: Long = 0L,
        val fullyHighlighted: Boolean = false,
        val value: String? = "",
        val matchLevel: String? = "",
        val matchedWords: String? = ""
)