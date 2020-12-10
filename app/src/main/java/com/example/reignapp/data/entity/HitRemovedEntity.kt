package com.example.reignapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HitRemovedEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0L,
        var title: String = ""
)
