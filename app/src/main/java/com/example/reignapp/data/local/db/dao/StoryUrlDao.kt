package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reignapp.data.entity.StoryUrlEntity

@Dao
interface StoryUrlDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(storyUrlEntity: StoryUrlEntity)

    @Query("SELECT * FROM StoryUrlEntity")
    fun getAll(): List<StoryUrlEntity>
}