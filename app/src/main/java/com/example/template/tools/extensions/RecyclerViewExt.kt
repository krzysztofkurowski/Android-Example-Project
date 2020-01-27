package com.example.template.tools.extensions

import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addDefaultConfiguration(activity: FragmentActivity?) {
    activity?.let {
        itemAnimator = DefaultItemAnimator()
        addItemDecoration(DividerItemDecoration(it, RecyclerView.VERTICAL))
    }
}