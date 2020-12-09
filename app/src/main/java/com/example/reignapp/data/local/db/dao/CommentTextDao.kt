package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.reignapp.data.entity.CommentTextEntity

@Dao
interface CommentTextDao {
    @Query("SELECT * FROM CommentTextEntity")
    fun getAll(): List<CommentTextEntity>
}