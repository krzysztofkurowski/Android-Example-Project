package com.example.template.cache.tools

import androidx.room.*
import com.example.template.cache.tools.diffUtil.DiffCallback
import com.example.template.cache.tools.diffUtil.EntityDiffUtil
import io.reactivex.Completable
import io.reactivex.Flowable

internal abstract class BaseDao<T> {

    abstract fun getAllLiveItems(): Flowable<List<T>>

    abstract fun getALlItems(): List<T>

    abstract fun clearTable(): Completable

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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSync(item: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSync(items: List<T>)

    @Update
    abstract fun updateSync(item: T)

    @Update
    abstract fun updateSync(items: List<T>)

    @Delete
    abstract fun deleteSync(item: T)

    @Delete
    abstract fun deleteSync(items: List<T>)

    @Transaction
    open fun makeDiff(diffCallback: DiffCallback<T>) =
        EntityDiffUtil(diffCallback).dispatchDiffUpdate(this)
}