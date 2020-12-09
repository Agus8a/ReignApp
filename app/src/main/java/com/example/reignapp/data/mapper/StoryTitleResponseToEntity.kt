package com.example.reignapp.data.mapper

import android.text.TextUtils
import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.StoryTitleEntity
import com.example.reignapp.data.remote.response.StoryTitleResponse

class StoryTitleResponseToEntity : BaseMapper<StoryTitleResponse, StoryTitleEntity>() {
    override fun map(input: StoryTitleResponse): StoryTitleEntity = StoryTitleEntity(
        value = input.value,
        matchLevel = input.matchLevel,
        matchedWords = TextUtils.join("@", input.matchedWords)
    )
}
