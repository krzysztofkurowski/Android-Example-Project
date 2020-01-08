package com.example.template.posts

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.databinding.FragmentPostBinding
import com.example.template.tools.base.BaseBindableFragment
import com.example.template.tools.extensions.addDefaultConfiguration
import kotlinx.android.synthetic.main.fragment_post.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostFragment : BaseBindableFragment<FragmentPostBinding>() {

    private val mViewModel: PostViewModel by viewModel {
        val userId = PostFragmentArgs.fromBundle(arguments).userId
        parametersOf(userId)
    }

    private val mAdapter by lazy { PostAdapter() }

    override fun getLayout() = R.layout.fragment_post

    override fun bindingData(mBinding: FragmentPostBinding) {
        mBinding.viewModel = mViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(rvPosts)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        with(recyclerView) {
            addDefaultConfiguration(activity)
            adapter = mAdapter
        }
    }
}