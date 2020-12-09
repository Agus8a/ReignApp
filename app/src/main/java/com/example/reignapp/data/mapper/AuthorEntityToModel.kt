package com.example.reignapp.data.mapper

import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.AuthorEntity
import com.example.reignapp.data.model.Author

class AuthorEntityToModel : BaseMapper<AuthorEntity, Author>() {
    override fun map(input: AuthorEntity): Author = Author(
        input.id,
        input.hitId,
        input.value,
        input.matchLevel,
        input.matchedWords
    )
}
