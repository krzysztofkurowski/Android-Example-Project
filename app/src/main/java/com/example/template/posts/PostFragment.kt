package com.example.template.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.databinding.FragmentPostBinding
import com.example.template.tools.base.BaseBindableFragment
import com.example.template.tools.extensions.addDefaultConfiguration
import kotlinx.android.synthetic.main.fragment_post.*
import javax.inject.Inject

class PostFragment : BaseBindableFragment<FragmentPostBinding>() {

    @Inject
    lateinit var vmFactory: PostViewModelFactory
    val userId by lazy { PostFragmentArgs.fromBundle(arguments).userId }
    private val mViewModel: PostViewModel by viewModels { vmFactory }

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