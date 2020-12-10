package com.example.reignapp.data.remote

import com.example.reignapp.data.LocalDataSource
import com.example.reignapp.data.RemoteDataSource
import com.example.reignapp.data.entity.AuthorEntity
import com.example.reignapp.data.entity.CommentTextEntity
import com.example.reignapp.data.entity.StoryTitleEntity
import com.example.reignapp.data.entity.StoryUrlEntity
import com.example.reignapp.data.mapper.*
import com.example.reignapp.data.remote.response.HackerNewsResponse
import com.example.reignapp.util.getTitle

class RemoteResponseDataSource(
    private val api: ApiService,
    private val localDataSource: LocalDataSource,
    private val hitResponseToEntity: HitResponseToEntity,
    private val authorResponseToEntity: AuthorResponseToEntity,
    private val commentTextResponseToEntity: CommentTextResponseToEntity,
    private val storyTitleResponseToEntity: StoryTitleResponseToEntity,
    private val storyUrlResponseToEntity: StoryUrlResponseToEntity
) : RemoteDataSource {
    override suspend fun getNews() {
        val hackerNewsResponse: HackerNewsResponse
        try {
            hackerNewsResponse = api.getHackerNews()
        } catch (e: Exception) {
            return
        }

        val storyTitlesFromResponse = mutableListOf<String>()
        val storyIdsDeleted = localDataSource.getStoriesDeleted()

        hackerNewsResponse.hits.takeIf { !it.isNullOrEmpty() }?.forEach {
            val currentHit = hitResponseToEntity.map(it)
            val title = currentHit.getTitle()
            if (!((currentHit.title.isNullOrEmpty() && currentHit.storyTitle.isNullOrEmpty()) ||
                            storyTitlesFromResponse.contains(title) || storyIdsDeleted.contains(title)
                            )) {
                storyTitlesFromResponse.add(title)
                val currentAuthor: AuthorEntity
                val currentComment: CommentTextEntity
                val currentStoryTitle: StoryTitleEntity
                val currentStoryUrl: StoryUrlEntity

                currentHit.title = title
                val hitIndex = localDataSource.saveHit(currentHit)
                if (it.highlightResult.author != null) {
                    currentAuthor =
                            authorResponseToEntity.map(it.highlightResult.author)
                    currentAuthor.hitId = hitIndex
                    localDataSource.saveAuthor(currentAuthor)
                }
                if (it.highlightResult.commentText != null) {
                    currentComment =
                        commentTextResponseToEntity.map(it.highlightResult.commentText)
                    currentComment.hitId = hitIndex
                    localDataSource.saveComment(currentComment)
                }
                if (it.highlightResult.storyTitle != null) {
                    currentStoryTitle =
                        storyTitleResponseToEntity.map(it.highlightResult.storyTitle)
                    currentStoryTitle.hitId = hitIndex
                    localDataSource.saveStoryTitle(currentStoryTitle)
                }
                if (it.highlightResult.storyUrl != null) {
                    currentStoryUrl =
                        storyUrlResponseToEntity.map(it.highlightResult.storyUrl)
                    currentStoryUrl.hitId = hitIndex
                    localDataSource.saveStoryUrl(currentStoryUrl)
                }
            }
        }
    }
}