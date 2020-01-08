package com.example.template.posts

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import com.example.template.R
import com.example.template.model.Post
import com.example.template.tools.base.BaseAdapter

class PostAdapter: BaseAdapter<Post>() {

    override fun getLayout() = R.layout.item_post

    override fun bindingData(binding: ViewDataBinding, item: Post) {
        binding.setVariable(BR.Post, item)
        binding.executePendingBindings()
    }
}