package com.example.reignapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StoryTitleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    var hitId: Long = 0L,
    val value: String? = "",
    val matchLevel: String? = "",
    val matchedWords: String? = ""
)