package com.example.reignapp.data.mapper

import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.StoryUrlEntity
import com.example.reignapp.data.model.StoryUrl

class StoryUrlEntityToModel : BaseMapper<StoryUrlEntity, StoryUrl>() {
    override fun map(input: StoryUrlEntity): StoryUrl = StoryUrl(
        input.id,
        input.hitId,
        input.value,
        input.matchLevel,
        input.matchedWords
    )
}
