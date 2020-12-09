package com.example.reignapp.data.model

data class Hit(
        val id: Long = 0L,
        val createdString: String? = "",
        val title: String? = "",
        val url: String? = "",
        val author: String? = "",
        val points: String? = "",
        val storyText: String? = "",
        val commentText: String? = "",
        val numComments: String? = "",
        val storyId: Int = 0,
        val storyTitle: String? = "",
        val storyUrl: String? = "",
        val parentId: Int = 0,
        val created: Long = 0L,
        val listTags: String? = "",
        val objectId: Int = 0,
        var authorHighlight: Author? = Author(),
        var commentTextHighlight: CommentText? = CommentText(),
        var storyTitleHighlight: StoryTitle? = StoryTitle(),
        var storyUrlHighlight: StoryUrl? = StoryUrl()
)

