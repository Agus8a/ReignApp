package com.example.reignapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class HighlightResultResponse(
    @SerializedName("author") val author: AuthorResponse,
    @SerializedName("comment_text") val commentText: CommentTextResponse,
    @SerializedName("story_title") val storyTitle: StoryTitleResponse,
    @SerializedName("story_url") val storyUrl: StoryUrlResponse
)

