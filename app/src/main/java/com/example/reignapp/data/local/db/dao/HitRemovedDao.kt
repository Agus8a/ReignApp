package com.example.reignapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reignapp.data.entity.HitRemovedEntity

@Dao
interface HitRemovedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(hitRemovedEntity: HitRemovedEntity)

    @Query("SELECT * FROM HitRemovedEntity")
    fun getAll(): List<HitRemovedEntity>
}