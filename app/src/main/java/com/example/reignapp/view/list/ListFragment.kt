package com.example.reignapp.view.list

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reignapp.R
import com.example.reignapp.core.BaseFragment
import com.example.reignapp.core.BaseOnSelectItem
import com.example.reignapp.data.model.Hit
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ListFragment : BaseFragment<ListViewModel>(), BaseOnSelectItem<Hit> {

    private lateinit var listAdapter: ListAdapter

    override fun getLayoutResource(): Int = R.layout.fragment_list

    override fun initViewModel(): ListViewModel = getViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val hitsObserver = Observer<List<Hit>> { hits ->
            updateList(hits)
        }
        viewModel.hits.observe(viewLifecycleOwner, hitsObserver)
        listAdapter = ListAdapter(requireContext(), this)
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
        fragment_list_swipe_refresh.setOnRefreshListener {
            fragment_list_swipe_refresh.isRefreshing = false
            getHits()
        }
    }

    private fun updateList(hits: List<Hit>) {
        listAdapter.setData(hits)
        fragment_list_progress_bar.visibility = GONE
        fragment_list_swipe_refresh.visibility = VISIBLE
    }

    private fun getHits() {
        fragment_list_progress_bar.visibility = VISIBLE
        fragment_list_swipe_refresh.visibility = GONE
        viewModel.getHits()
    }

    override fun onSelectItem(item: Hit) {
        Toast.makeText(requireContext(), item.author, Toast.LENGTH_SHORT).show()
    }

}

