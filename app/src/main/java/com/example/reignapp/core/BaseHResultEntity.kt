package com.example.reignapp.core

abstract class BaseHResultEntity(
    val hitId: Long = 0L,
    val value: String = "",
    val matchLevel: String = "",
    val matchedWords: List<String> = listOf()
)