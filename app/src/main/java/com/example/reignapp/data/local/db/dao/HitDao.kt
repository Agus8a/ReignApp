package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.reignapp.data.entity.HitEntity

@Dao
interface HitDao {
    @Query("SELECT * FROM HitEntity")
    fun getAll(): List<HitEntity>
}