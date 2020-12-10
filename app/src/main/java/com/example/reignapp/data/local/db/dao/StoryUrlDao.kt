package com.example.reignapp.data.local.db.dao

import androidx.room.*
import com.example.reignapp.data.entity.StoryUrlEntity

@Dao
interface StoryUrlDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(storyUrlEntity: StoryUrlEntity)

    @Query("SELECT * FROM StoryUrlEntity")
    fun getAll(): List<StoryUrlEntity>

    @Query("SELECT * FROM StoryUrlEntity WHERE hitId = :hitId")
    fun getByHitId(hitId: Long): StoryUrlEntity?

    @Delete
    fun delete(storyUrlEntity: StoryUrlEntity)
}