package com.example.reignapp.data.local

import com.example.reignapp.data.LocalDataSource
import com.example.reignapp.data.entity.*
import com.example.reignapp.data.local.db.ReignDatabase
import com.example.reignapp.util.getTitle

class LocalHitDataSource(
    private val db: ReignDatabase
) : LocalDataSource {

    override suspend fun saveHit(hitEntity: HitEntity): Long {
        val previousEntity = db.HitDao().getByTitle(hitEntity.title!!)
        if (previousEntity != null) {
            deleteHit(previousEntity, false)
        }
        return db.HitDao().insert(hitEntity)
    }

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

    override suspend fun getStoriesDeleted(): List<String> {
        val hitsDeleted = db.HitRemovedDao().getAll()
        val listTitles = mutableListOf<String>()
        hitsDeleted.takeIf { !it.isNullOrEmpty() }?.forEach {
            listTitles.add(it.title)
        }
        return listTitles
    }

    override suspend fun deleteHit(hitEntity: HitEntity, addRemovedEntity: Boolean) {
        if (addRemovedEntity) {
            val hitRemovedEntity = HitRemovedEntity(title = hitEntity.getTitle())
            db.HitRemovedDao().insert(hitRemovedEntity)
        }
        db.HitDao().delete(hitEntity)

        val authorEntity = db.AuthorDao().getByHitId(hitEntity.id)
        if (authorEntity != null) {
            db.AuthorDao().delete(authorEntity)
        }
        val commentTextEntity = db.CommentTextDao().getByHitId(hitEntity.id)
        if (commentTextEntity != null) {
            db.CommentTextDao().delete(commentTextEntity)
        }
        val storyUrlEntity = db.StoryUrlDao().getByHitId(hitEntity.id)
        if (storyUrlEntity != null) {
            db.StoryUrlDao().delete(storyUrlEntity)
        }
        val storyTitleEntity = db.StoryTitleDao().getByHitId(hitEntity.id)
        if (storyTitleEntity != null) {
            db.StoryTitleDao().delete(storyTitleEntity)
        }
    }
}