package com.example.template.cache

import android.content.Context
import androidx.room.Room

const val DATABASE_NAME = "database_name"

internal object DatabaseClient {
    fun getClient(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
}

