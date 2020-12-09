package com.example.reignapp.data.mapper

import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.StoryTitleEntity
import com.example.reignapp.data.model.StoryTitle

class StoryTitleEntityToModel : BaseMapper<StoryTitleEntity, StoryTitle>() {
    override fun map(input: StoryTitleEntity): StoryTitle = StoryTitle(
        input.id,
        input.hitId,
        input.value,
        input.matchLevel,
        input.matchedWords
    )
}
