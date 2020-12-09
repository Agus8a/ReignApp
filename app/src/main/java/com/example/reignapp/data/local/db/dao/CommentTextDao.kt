package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reignapp.data.entity.CommentTextEntity

@Dao
interface CommentTextDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(commentTextEntity: CommentTextEntity)

    @Query("SELECT * FROM CommentTextEntity")
    fun getAll(): List<CommentTextEntity>
}