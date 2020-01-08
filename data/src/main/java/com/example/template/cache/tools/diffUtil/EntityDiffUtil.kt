package com.example.template.cache.tools.diffUtil

import com.example.template.cache.tools.BaseDao

internal class EntityDiffUtil<T>(private val diffCallback: DiffCallback<T>) {

    suspend fun dispatchDiffUpdate(dao: BaseDao<T>) {

        val newEntryList = diffCallback.getNewItemList()
        val oldEntryList = diffCallback.getOldItemList()

        val (commonEntries, newEntries) = newEntryList.partition { newEntry ->
            oldEntryList.any { diffCallback.areItemsTheSame(it, newEntry) }
        }

        val removedEntries = oldEntryList.filterNot { oldEntry ->
            commonEntries.any { diffCallback.areItemsTheSame(oldEntry, it) }
        }

        dao.delete(removedEntries)
        dao.update(commonEntries)
        dao.insert(newEntries)
    }
}