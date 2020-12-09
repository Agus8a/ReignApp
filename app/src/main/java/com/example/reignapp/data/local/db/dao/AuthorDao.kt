package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reignapp.data.entity.AuthorEntity

@Dao
interface AuthorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(authorEntity: AuthorEntity)

    @Query("SELECT * FROM AuthorEntity")
    fun getAll(): List<AuthorEntity>
}