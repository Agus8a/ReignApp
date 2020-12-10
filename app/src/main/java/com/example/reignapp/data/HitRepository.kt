package com.example.reignapp.data

import com.example.reignapp.data.model.Hit

interface HitRepository {
    suspend fun getHits(): List<Hit>
    suspend fun deleteHit(hit: Hit)
}