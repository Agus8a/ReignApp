package com.example.reignapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CommentTextEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    var hitId: Long = 0L,
    val fullyHighlighted: Boolean = false,
    val value: String? = "",
    val matchLevel: String? = "",
    val matchedWords: String? = ""
)