package com.example.template.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.template.cache.user.UserDao
import com.example.template.cache.model.PostEntity
import com.example.template.cache.model.UserEntity
import com.example.template.cache.post.PostDao

@Database(
    entities = [UserEntity::class, PostEntity::class],
    version = 2
)
@TypeConverters(DatabaseConverters::class)
internal abstract class MyDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getPostsDao(): PostDao
}