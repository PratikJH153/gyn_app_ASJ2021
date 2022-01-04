package com.example.listview_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gyn_app_asj_2021.R
import com.example.gyn_app_asj_2021.Task
import de.hdodenhof.circleimageview.CircleImageView

class Adapter(private val dataList: List<Task>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    // Represents a single row in a list
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize
        val iconView:CircleImageView = itemView.findViewById(R.id.icon)
        val textView1: TextView = itemView.findViewById(R.id.tag)
        val textView2: TextView = itemView.findViewById(R.id.description)
        val checkedView: CheckBox = itemView.findViewById(R.id.checked)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.taskview, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]

        // setter
        holder.textView1.text = currentItem.tagName + position.toString()
        holder.textView2.text = currentItem.tagValue
        holder.iconView.setImageResource(currentItem.icon)
        holder.checkedView.setChecked(currentItem.isComplete)
    }

    override fun getItemCount() = dataList.size
}