package com.example.reignapp.data.mapper

import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.AuthorEntity
import com.example.reignapp.data.remote.response.AuthorResponse
import com.example.reignapp.util.listToString

class AuthorResponseToEntity : BaseMapper<AuthorResponse, AuthorEntity>() {
    override fun map(input: AuthorResponse): AuthorEntity = AuthorEntity(
        value = input.value,
        matchLevel = input.matchLevel,
        matchedWords = input.matchedWords.listToString()
    )
}
