package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.reignapp.data.entity.StoryTitleEntity

@Dao
interface StoryTitleDao {
    @Query("SELECT * FROM StoryTitleEntity")
    fun getAll(): List<StoryTitleEntity>
}