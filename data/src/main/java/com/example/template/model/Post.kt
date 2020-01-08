package com.example.template.model

import com.example.template.cache.model.PostEntity
import com.example.template.tools.BaseItem

data class Post(
    override val id: Int,
    val body: String,
    val title: String,
    val userId: Int
): BaseItem

internal fun Post.toEntity() = PostEntity(
    id.toLong(),
    body,
    title,
    userId
)

internal fun List<Post>.toEntities() = map { it.toEntity() }