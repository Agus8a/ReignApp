package com.example.reignapp.core

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.reignapp.R
import com.example.reignapp.view.main.MainActivity

abstract class BaseFragment<VM : ViewModel> : Fragment() {

    lateinit var viewModel: VM
    private var progressBar: ProgressBar? = null
    private lateinit var activity: MainActivity

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutResource(), container, false)
        viewModel = initViewModel()
        activity = requireActivity() as MainActivity
        return view
    }

    @Suppress("DEPRECATION")
    fun toastMsg(msg: String = "", length: Int = Toast.LENGTH_SHORT) {
        if (msg.isNotBlank()) {
            val toast = Toast.makeText(requireContext(), msg, length)
            val view = toast.view
            view?.background?.setColorFilter(requireContext().getColor(R.color.black), PorterDuff.Mode.SRC_IN)
            val tv = view?.findViewById<TextView>(android.R.id.message)
            tv?.setTextColor(requireContext().getColor(R.color.white))
            tv?.textAlignment = View.TEXT_ALIGNMENT_CENTER
            toast.show()
        }
    }

    fun setupHomeButton(enable: Boolean) {
        val title = if (enable) {
            getString(R.string.back)
        } else {
            getString(R.string.app_name)
        }
        activity.supportActionBar?.title = title
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(enable)
        activity.supportActionBar?.setDisplayShowHomeEnabled(enable)
    }

    abstract fun getLayoutResource(): Int
    abstract fun initViewModel(): VM

}