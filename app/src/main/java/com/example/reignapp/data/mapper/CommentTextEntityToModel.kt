package com.example.reignapp.data.mapper

import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.CommentTextEntity
import com.example.reignapp.data.model.CommentText

class CommentTextEntityToModel : BaseMapper<CommentTextEntity, CommentText>() {
    override fun map(input: CommentTextEntity): CommentText = CommentText(
        input.id,
        input.hitId,
        input.fullyHighlighted,
        input.value,
        input.matchLevel,
        input.matchedWords
    )
}
