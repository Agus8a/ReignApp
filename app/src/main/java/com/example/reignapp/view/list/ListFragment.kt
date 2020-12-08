package com.example.reignapp.view.list

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.reignapp.R
import com.example.reignapp.core.BaseFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ListFragment : BaseFragment<ListViewModel>() {

    override fun getLayoutResource(): Int = R.layout.fragment_list

    override fun initViewModel(): ListViewModel = getViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<TextView>(R.id.tv).setOnClickListener {
            getHit()
        }
    }

    private fun getHit() {
        lifecycleScope.launch {
            viewModel.getNews()
        }
    }
}