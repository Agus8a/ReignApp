package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reignapp.data.entity.StoryTitleEntity

@Dao
interface StoryTitleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(storyTitleEntity: StoryTitleEntity)

    @Query("SELECT * FROM StoryTitleEntity")
    fun getAll(): List<StoryTitleEntity>
}