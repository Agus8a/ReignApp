package com.example.reignapp.data.local

import com.example.reignapp.data.LocalDataSource
import com.example.reignapp.data.entity.*
import com.example.reignapp.data.local.db.ReignDatabase

class LocalHitDataSource(
    private val db: ReignDatabase
) : LocalDataSource {

    override suspend fun saveHit(hitEntity: HitEntity): Long =
        db.HitDao().insert(hitEntity)


    override suspend fun saveAuthor(authorEntity: AuthorEntity) {
        db.AuthorDao().insert(authorEntity)
    }

    override suspend fun saveComment(commentTextEntity: CommentTextEntity) {
        db.CommentTextDao().insert(commentTextEntity)
    }

    override suspend fun saveStoryTitle(storyTitleEntity: StoryTitleEntity) {
        db.StoryTitleDao().insert(storyTitleEntity)
    }

    override suspend fun saveStoryUrl(storyUrlEntity: StoryUrlEntity) {
        db.StoryUrlDao().insert(storyUrlEntity)
    }

    override suspend fun getHits(): List<HitEntity> =
        db.HitDao().getAll()

    override suspend fun getAuthors(): List<AuthorEntity> =
        db.AuthorDao().getAll()

    override suspend fun getComments(): List<CommentTextEntity> =
        db.CommentTextDao().getAll()

    override suspend fun getStoryUrls(): List<StoryUrlEntity> =
        db.StoryUrlDao().getAll()

    override suspend fun getStoryTitles(): List<StoryTitleEntity> =
        db.StoryTitleDao().getAll()

    override suspend fun deleteOldData() {
        db.clearAllTables()
    }
}