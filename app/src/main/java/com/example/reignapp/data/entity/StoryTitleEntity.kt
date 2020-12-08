package com.example.reignapp.data.entity

import androidx.room.PrimaryKey
import com.example.reignapp.core.BaseHResultEntity

data class StoryTitleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
) : BaseHResultEntity()