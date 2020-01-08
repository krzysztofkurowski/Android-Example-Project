package com.example.template.remote.model

import com.example.template.model.Post

internal data class PostDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

internal fun PostDto.toPost() = Post(
    id,
    body,
    title,
    userId
)

internal fun List<PostDto>.toPosts() = map { it.toPost() }