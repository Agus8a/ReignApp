package com.example.reignapp.data.repository

import com.example.reignapp.data.HitRepository
import com.example.reignapp.data.LocalDataSource
import com.example.reignapp.data.RemoteDataSource
import com.example.reignapp.data.mapper.*
import com.example.reignapp.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HitRepositoryImpl(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val hitEntityToModel: HitEntityToModel,
        private val commentTextEntityToModel: CommentTextEntityToModel,
        private val authorEntityToModel: AuthorEntityToModel,
        private val storyTitleEntityToModel: StoryTitleEntityToModel,
        private val storyUrlEntityToModel: StoryUrlEntityToModel,
        private val hitModelToEntity: HitModelToEntity
) : HitRepository {
    override suspend fun getHits(): List<Hit> {
        var hits: List<Hit> = listOf()
        var authors: List<Author> = listOf()
        var comments: List<CommentText> = listOf()
        var storyTitles: List<StoryTitle> = listOf()
        var storyUrls: List<StoryUrl> = listOf()

        withContext(Dispatchers.IO) {
            remoteDataSource.getNews()
            hits = hitEntityToModel.mapAll(localDataSource.getHits())
            authors = authorEntityToModel.mapAll(localDataSource.getAuthors())
            comments = commentTextEntityToModel.mapAll(localDataSource.getComments())
            storyTitles = storyTitleEntityToModel.mapAll(localDataSource.getStoryTitles())
            storyUrls = storyUrlEntityToModel.mapAll(localDataSource.getStoryUrls())
        }

        hits.takeIf { !it.isNullOrEmpty() }?.forEach {
            it.authorHighlight = authors.find { author -> author.hitId == it.id }
            it.commentTextHighlight =
                    comments.find { comment -> comment.hitId == it.id }
            it.storyTitleHighlight =
                    storyTitles.find { storyTitle -> storyTitle.hitId == it.id }
            it.storyUrlHighlight =
                    storyUrls.find { storyUrl -> storyUrl.hitId == it.id }
        }
        return hits.sortedByDescending { it.created }
    }

    override suspend fun deleteHit(hit: Hit) {
        withContext(Dispatchers.IO) {
            localDataSource.deleteHit(hitModelToEntity.map(hit))
        }
    }
}