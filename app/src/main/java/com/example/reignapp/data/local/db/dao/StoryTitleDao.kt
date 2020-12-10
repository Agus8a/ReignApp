package com.example.reignapp.data.local.db.dao

import androidx.room.*
import com.example.reignapp.data.entity.StoryTitleEntity

@Dao
interface StoryTitleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(storyTitleEntity: StoryTitleEntity)

    @Query("SELECT * FROM StoryTitleEntity")
    fun getAll(): List<StoryTitleEntity>

    @Query("SELECT * FROM StoryTitleEntity WHERE hitId = :hitId")
    fun getByHitId(hitId: Long): StoryTitleEntity?

    @Delete
    fun delete(storyTitleEntity: StoryTitleEntity)
}