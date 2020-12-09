package com.example.reignapp.core

abstract class BaseHResultEntity(
        var hitId: Long = 0L,
        var value: String = "",
        var matchLevel: String = "",
        var matchedWords: String = ""
)