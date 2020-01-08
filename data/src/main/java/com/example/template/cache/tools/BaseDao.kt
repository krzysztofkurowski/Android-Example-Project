package com.example.template.cache.tools

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Transaction
import androidx.room.Update
import com.example.template.cache.tools.diffUtil.DiffCallback
import com.example.template.cache.tools.diffUtil.EntityDiffUtil

internal abstract class BaseDao<T> {

    abstract fun getAllLiveItems(): LiveData<List<T>>

    abstract fun getALlItems(): List<T>

    abstract suspend fun clearTable()

    @Insert
    abstract suspend fun insert(item: T)

    @Insert
    abstract suspend fun insert(items: List<T>)

    @Update
    abstract suspend fun update(item: T)

    @Update
    abstract suspend fun update(items: List<T>)

    @Delete
    abstract suspend fun delete(item: T)

    @Delete
    abstract suspend fun delete(items: List<T>)

    @Transaction
    open suspend fun makeDiff(diffCallback: DiffCallback<T>) =
        EntityDiffUtil(diffCallback).dispatchDiffUpdate(this)
}