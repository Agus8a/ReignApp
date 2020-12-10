package com.example.reignapp.data.local.db.dao

import androidx.room.*
import com.example.reignapp.data.entity.HitEntity

@Dao
interface HitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(hitEntity: HitEntity): Long

    @Query("SELECT * FROM HitEntity")
    fun getAll(): List<HitEntity>

    @Query("SELECT * FROM HitEntity WHERE title = :title")
    fun getByTitle(title: String): HitEntity?

    @Delete
    fun delete(hitEntity: HitEntity)
}