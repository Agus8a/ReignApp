package com.example.reignapp.view.list

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.reignapp.R
import com.example.reignapp.core.BaseOnTriggerItem
import com.example.reignapp.data.model.Hit
import com.example.reignapp.util.getAuthorAndDate
import com.example.reignapp.util.getTitle
import kotlinx.android.synthetic.main.view_list_item.view.*


class ListAdapter(
        private val context: Context,
        private val onTriggerItem: BaseOnTriggerItem<Hit>
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
            onTriggerItem.onSelectItem(listHits[holder.adapterPosition])
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

    inner class SwipeToDeleteCallback : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT
    ) {
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            onTriggerItem.onDeleteItem(listHits, viewHolder.adapterPosition)
        }

        override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

            val icon = ContextCompat.getDrawable(context, R.drawable.ic_delete)
            val background = ColorDrawable(context.getColor(R.color.red))
            val itemView = viewHolder.itemView
            val iconMargin = (itemView.height - icon!!.intrinsicHeight) / 2
            val iconTop = itemView.top + (itemView.height - icon.intrinsicHeight) / 2
            val iconBottom = iconTop + icon.intrinsicHeight
            val iconLeft = itemView.right - iconMargin - icon.intrinsicWidth
            val iconRight = itemView.right - iconMargin

            background.setBounds(itemView.right + dX.toInt(),
                    itemView.top, itemView.right, itemView.bottom)
            background.draw(c)
            icon.setBounds(iconLeft, iconTop, iconRight, iconBottom)
            icon.draw(c)
        }
    }
}