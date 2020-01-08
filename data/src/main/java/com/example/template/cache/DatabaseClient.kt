package com.example.template.cache

import android.content.Context
import androidx.room.Room

const val DATABASE_NAME = "database_name"

internal object DatabaseClient {

    @Volatile
    private var INSTANCE: MyDatabase? = null

    fun getInstance(context: Context): MyDatabase =
        INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

    private fun buildDatabase(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java, DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
}

