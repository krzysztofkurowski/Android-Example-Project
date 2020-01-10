package com.example.template.user

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import com.example.template.R
import com.example.template.model.User
import com.example.template.tools.base.BaseAdapter
import com.example.template.tools.base.ItemClickListener

class UserAdapter(private val mListener: ItemClickListener<User>) : BaseAdapter<User>() {

    override fun getLayout() = R.layout.item_user

    override fun bindingData(binding: ViewDataBinding, item: User) {
        binding.setVariable(BR.User, item)
        binding.setVariable(BR.Listener, mListener)
        binding.executePendingBindings()
    }
}