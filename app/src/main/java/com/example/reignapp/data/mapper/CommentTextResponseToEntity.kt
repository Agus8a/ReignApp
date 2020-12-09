package com.example.reignapp.data.mapper

import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.CommentTextEntity
import com.example.reignapp.data.remote.response.CommentTextResponse
import com.example.reignapp.util.listToString

class CommentTextResponseToEntity : BaseMapper<CommentTextResponse, CommentTextEntity>() {
    override fun map(input: CommentTextResponse): CommentTextEntity =
        CommentTextEntity(
            value = input.value,
            matchLevel = input.matchLevel,
            matchedWords = input.matchedWords.listToString(),
            fullyHighlighted = input.fullyHighlighted
        )
}
