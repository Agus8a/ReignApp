package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.reignapp.data.entity.StoryUrlEntity

@Dao
interface StoryUrlDao {
    @Query("SELECT * FROM StoryUrlEntity")
    fun getAll(): List<StoryUrlEntity>
}