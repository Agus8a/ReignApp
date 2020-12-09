package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.reignapp.data.entity.AuthorEntity

@Dao
interface AuthorDao {
    @Query("SELECT * FROM AuthorEntity")
    fun getAll(): List<AuthorEntity>
}