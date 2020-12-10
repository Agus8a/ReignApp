package com.example.reignapp.data.local.db.dao

import androidx.room.*
import com.example.reignapp.data.entity.AuthorEntity

@Dao
interface AuthorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(authorEntity: AuthorEntity)

    @Query("SELECT * FROM AuthorEntity")
    fun getAll(): List<AuthorEntity>

    @Query("SELECT * FROM AuthorEntity WHERE hitId = :hitId")
    fun getByHitId(hitId: Long): AuthorEntity?

    @Delete
    fun delete(authorEntity: AuthorEntity)
}