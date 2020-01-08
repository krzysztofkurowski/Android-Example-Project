package com.example.template.tools.binding_adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("data")
fun RecyclerView.data(items: List<Nothing>?) {
    items ?: return
    (adapter as? ListAdapter<*, *>)?.submitList(items)
}