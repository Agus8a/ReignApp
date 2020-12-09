package com.example.reignapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.reignapp.core.BaseHResultEntity

@Entity
data class StoryUrlEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0L
) : BaseHResultEntity()