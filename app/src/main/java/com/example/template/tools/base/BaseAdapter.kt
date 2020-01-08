package com.example.template.tools.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.template.tools.BaseItem

abstract class BaseAdapter<T : BaseItem> : ListAdapter<T, BaseViewHolder>(BaseDiffUtil<T>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, getLayout(), parent, false)
        return BaseViewHolder(binding)
    }

    abstract fun getLayout(): Int

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)

        item?.let {
            bindingData(holder.binding, it)
        }
    }

    abstract fun bindingData(binding: ViewDataBinding, item: T)
}

class BaseViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

class BaseDiffUtil<T : BaseItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: T, newItem: T) =
        oldItem == newItem
}