package com.example.reignapp.view.list

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.reignapp.R
import com.example.reignapp.core.BaseFragment
import com.example.reignapp.data.model.Hit
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ListFragment : BaseFragment<ListViewModel>() {

    override fun getLayoutResource(): Int = R.layout.fragment_list

    override fun initViewModel(): ListViewModel = getViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val hitsObserver = Observer<List<Hit>> { hits ->
            updateList(hits)
        }
        viewModel.hits.observe(viewLifecycleOwner, hitsObserver)

        view.findViewById<TextView>(R.id.tv).setOnClickListener {
            getHit()
        }
    }

    private fun updateList(hits: List<Hit>) {
        Toast.makeText(requireContext(), hits.first().createdString, Toast.LENGTH_SHORT).show()
    }

    private fun getHit() {
        viewModel.getHits()
    }

}

