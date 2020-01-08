package com.example.template.cache.model

import androidx.room.*
import com.example.template.cache.tools.BaseEntityItem
import com.example.template.model.Post

@Entity(
    tableName = PostEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = [UserEntity.COLUMN_ID],
            childColumns = [PostEntity.COLUMN_USER_ID],
            onDelete = ForeignKey.CASCADE
        )],
    indices = [Index(PostEntity.COLUMN_USER_ID)]
)
internal data class PostEntity(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    override val id: Long,
    val body: String,
    val title: String,
    @ColumnInfo(name = COLUMN_USER_ID)
    val userId: Int
) : BaseEntityItem {
    companion object {
        const val TABLE_NAME = "table_post"
        const val COLUMN_ID = "post_id"
        const val COLUMN_USER_ID = "user_id_child"
    }
}

internal fun PostEntity.toPost() = Post(
    id.toInt(),
    body,
    title,
    userId
)

internal fun List<PostEntity>.toPosts() = map { it.toPost() }