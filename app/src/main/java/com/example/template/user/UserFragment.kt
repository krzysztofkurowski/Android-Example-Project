package com.example.template.user

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.databinding.FragmentUserBinding
import com.example.template.model.User
import com.example.template.tools.base.BaseBindableFragment
import com.example.template.tools.base.ItemClickListener
import com.example.template.tools.extensions.addDefaultConfiguration
import kotlinx.android.synthetic.main.fragment_user.*
import org.koin.android.viewmodel.ext.android.viewModel

class UserFragment : BaseBindableFragment<FragmentUserBinding>(), ItemClickListener<User> {

    private val mViewModel: UserViewModel by viewModel()
    private val mAdapter by lazy { UserAdapter(this) }

    override fun getLayout() = R.layout.fragment_user

    override fun onItemClicked(item: User) {
        val userId = item.id
        val action = UserFragmentDirections.goToPosts(userId)
        findNavController().navigate(action)
    }

    override fun bindingData(mBinding: FragmentUserBinding) {
        mBinding.viewModel = mViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(rvUsers)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        with(recyclerView) {
            addDefaultConfiguration(activity)
            adapter = mAdapter
        }
    }
}