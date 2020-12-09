package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reignapp.data.entity.HitEntity

@Dao
interface HitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(hitEntity: HitEntity): Long

    @Query("SELECT * FROM HitEntity")
    fun getAll(): List<HitEntity>
}