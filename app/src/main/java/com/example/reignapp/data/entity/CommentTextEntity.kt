package com.example.reignapp.data.entity

import androidx.room.PrimaryKey
import com.example.reignapp.core.BaseHResultEntity

data class CommentTextEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val fullyHighlighted: Boolean = false
) : BaseHResultEntity()