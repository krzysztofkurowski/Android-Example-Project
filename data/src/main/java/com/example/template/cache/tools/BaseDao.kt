package com.example.template.cache.tools

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.template.cache.tools.diffUtil.DiffCallback
import com.example.template.cache.tools.diffUtil.EntityDiffUtil
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

internal abstract class BaseDao<T> {

    abstract fun getAllLiveItems(): Flowable<List<T>>

    abstract fun getALlItems(): List<T>

    abstract fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(item: T): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(items: List<T>): Completable

    @Update
    abstract fun update(item: T): Completable

    @Update
    abstract fun update(items: List<T>): Completable

    @Delete
    abstract fun delete(item: T): Completable

    @Delete
    abstract fun delete(items: List<T>): Completable

    @Transaction
    open fun makeDiff(diffCallback: DiffCallback<T>) =
        EntityDiffUtil(diffCallback).dispatchDiffUpdate(this)
}