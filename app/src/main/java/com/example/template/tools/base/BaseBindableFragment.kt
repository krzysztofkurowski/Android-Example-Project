package com.example.template.tools.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

abstract class BaseBindableFragment<T : ViewDataBinding> : DaggerFragment() {

    private lateinit var mBinding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    @LayoutRes
    abstract fun getLayout(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingData(mBinding)
    }

    abstract fun bindingData(mBinding: T)
}