package com.example.reignapp.view.list

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reignapp.R
import com.example.reignapp.core.BaseFragment
import com.example.reignapp.data.model.Hit
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ListFragment : BaseFragment<ListViewModel>() {

    private lateinit var listAdapter: ListAdapter

    override fun getLayoutResource(): Int = R.layout.fragment_list

    override fun initViewModel(): ListViewModel = getViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val hitsObserver = Observer<List<Hit>> { hits ->
            updateList(hits)
        }
        viewModel.hits.observe(viewLifecycleOwner, hitsObserver)
        listAdapter = ListAdapter(requireContext())
        initViews()
        fragment_list_recycler_view.adapter = listAdapter

    }

    private fun initViews() {
        fragment_list_progress_bar.visibility = VISIBLE
        fragment_list_recycler_view.apply {
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
        }
    }

    private fun updateList(hits: List<Hit>) {
        listAdapter.setData(hits)
        fragment_list_progress_bar.visibility = GONE
        fragment_list_recycler_view.visibility = VISIBLE
    }

    private fun getHit() {
        fragment_list_progress_bar.visibility = VISIBLE
        fragment_list_recycler_view.visibility = GONE
        viewModel.getHits()
    }

}

