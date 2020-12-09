package com.example.reignapp.data.mapper

import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.HitEntity
import com.example.reignapp.data.remote.response.HitResponse
import com.example.reignapp.util.listToString

class HitResponseToEntity : BaseMapper<HitResponse, HitEntity>() {
        override fun map(input: HitResponse): HitEntity = HitEntity(
                id = 0L,
                input.createdString,
                input.title,
                input.url,
                input.author,
                input.points,
                input.storyText,
                input.commentText,
                input.numComments,
                input.storyId,
                input.storyTitle,
                input.storyUrl,
                input.parentId,
                input.created,
                listTags = input.listTags.listToString(),
                input.objectId
        )
}
