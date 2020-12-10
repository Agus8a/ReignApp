package com.example.reignapp.data.mapper

import com.example.reignapp.core.BaseMapper
import com.example.reignapp.data.entity.HitEntity
import com.example.reignapp.data.model.Hit

class HitModelToEntity : BaseMapper<Hit, HitEntity>() {
    override fun map(input: Hit): HitEntity = HitEntity(
            input.id,
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
            input.listTags,
            input.objectId
    )
}
