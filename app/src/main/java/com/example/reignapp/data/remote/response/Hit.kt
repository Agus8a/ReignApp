package com.example.reignapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class Hit(
    @SerializedName("created_at") val createdString: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("author") val author: String,
    @SerializedName("points") val points: String,
    @SerializedName("story_text") val storyText: String,
    @SerializedName("comment_text") val commentText: String,
    @SerializedName("num_comments") val numComments: String,
    @SerializedName("story_id") val storyId: Int,
    @SerializedName("story_title") val storyTitle: String,
    @SerializedName("story_url") val storyUrl: String,
    @SerializedName("parent_id") val parentId: Int,
    @SerializedName("created_at_i") val created: Int,
    @SerializedName("_tags") val listTags: List<String>,
    @SerializedName("objectID") val objectId: Int,
    @SerializedName("_highlightResult") val highlightResult: HighlightResult
)

