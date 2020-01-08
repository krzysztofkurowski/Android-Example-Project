package com.example.template.cache.tools.diffUtil

import com.example.template.cache.tools.BaseEntityItem

interface DiffCallback<T> {
    fun getOldItemList(): Collection<T>
    fun getNewItemList(): Collection<T>
    fun areItemsTheSame(oldItem: T, newItem: T): Boolean
}

internal open class BaseDiffCallback<T : BaseEntityItem>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffCallback<T> {

    override fun getOldItemList(): Collection<T> = oldList

    override fun getNewItemList(): Collection<T> = newList

    override fun areItemsTheSame(oldItem: T, newItem: T) = (oldItem.id == newItem.id)
}

internal class BaseDiffCallbackForItem<T : BaseEntityItem>(
    oldItem: T,
    newItem: T
) :
    BaseDiffCallback<T>(
        listOf(oldItem),
        listOf(newItem)
    )

