package com.example.reignapp.data.mapper

import android.text.TextUtils
import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.StoryUrlEntity
import com.example.reignapp.data.remote.response.StoryUrlResponse

class StoryUrlResponseToEntity : BaseMapper<StoryUrlResponse, StoryUrlEntity>() {
    override fun map(input: StoryUrlResponse): StoryUrlEntity = StoryUrlEntity(
        value = input.value,
        matchLevel = input.matchLevel,
        matchedWords = TextUtils.join("@", input.matchedWords)
    )
}
