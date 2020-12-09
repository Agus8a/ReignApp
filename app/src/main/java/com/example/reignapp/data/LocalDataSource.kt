package com.example.reignapp.data

import com.example.reignapp.data.entity.*

interface LocalDataSource {
    suspend fun saveHit(hitEntity: HitEntity): Long
    suspend fun saveAuthor(authorEntity: AuthorEntity)
    suspend fun saveComment(commentTextEntity: CommentTextEntity)
    suspend fun saveStoryTitle(storyTitleEntity: StoryTitleEntity)
    suspend fun saveStoryUrl(storyUrlEntity: StoryUrlEntity)

    suspend fun getHits(): List<HitEntity>
    suspend fun getAuthors(): List<AuthorEntity>
    suspend fun getComments(): List<CommentTextEntity>
    suspend fun getStoryUrls(): List<StoryUrlEntity>
    suspend fun getStoryTitles(): List<StoryTitleEntity>

    suspend fun deleteOldData()
}