package com.example.reignapp.view.list

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reignapp.R
import com.example.reignapp.core.BaseFragment
import com.example.reignapp.core.BaseOnTriggerItem
import com.example.reignapp.data.model.Hit
import com.example.reignapp.util.KEY_ARGS_STORY_URL
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ListFragment : BaseFragment<ListViewModel>(), BaseOnTriggerItem<Hit> {

    private lateinit var listAdapter: ListAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

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
        itemTouchHelper = ItemTouchHelper(listAdapter.SwipeToDeleteCallback())
        itemTouchHelper.attachToRecyclerView(fragment_list_recycler_view)
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
        val bundle = bundleOf()
        bundle.putString(
                KEY_ARGS_STORY_URL,
                item.storyUrl
        )
        findNavController().navigate(
                R.id.navigation_action_list_to_detail,
                bundle
        )
    }

    override fun onDeleteItem(listItems: MutableList<Hit>, itemPosition: Int) {
        val item = listItems[itemPosition]
        listItems.removeAt(itemPosition)
        updateList(listItems)
        toastMsg(getString(R.string.post_deleted))
        viewModel.deleteHit(item)
    }

}

