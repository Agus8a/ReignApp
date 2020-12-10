package com.example.reignapp.view.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reignapp.R
import com.example.reignapp.core.BaseOnSelectItem
import com.example.reignapp.data.model.Hit
import com.example.reignapp.util.getAuthorAndDate
import com.example.reignapp.util.getTitle
import kotlinx.android.synthetic.main.view_list_item.view.*

class ListAdapter(
    private val context: Context,
    private val onSelectItem: BaseOnSelectItem<Hit>
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var listHits: List<Hit> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.view_list_item,
            parent,
            false
        )

        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {
            onSelectItem.onSelectItem(listHits[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hit = listHits[position]
        holder.title.text = hit.getTitle()
        holder.author.text = hit.getAuthorAndDate(context)
    }

    override fun getItemCount(): Int =
        listHits.size

    fun setData(newList: List<Hit>) {
        listHits = newList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.view_list_item_title
        val author: TextView = view.view_list_item_author
    }
}