package com.example.reignapp.data.local.db.dao

import androidx.room.*
import com.example.reignapp.data.entity.CommentTextEntity

@Dao
interface CommentTextDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(commentTextEntity: CommentTextEntity)

    @Query("SELECT * FROM CommentTextEntity")
    fun getAll(): List<CommentTextEntity>

    @Query("SELECT * FROM CommentTextEntity WHERE hitId = :hitId")
    fun getByHitId(hitId: Long): CommentTextEntity?

    @Delete
    fun delete(commentTextEntity: CommentTextEntity)
}