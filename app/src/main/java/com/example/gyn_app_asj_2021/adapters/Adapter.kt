package com.example.gyn_app_asj_2021.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gyn_app_asj_2021.R
import com.example.gyn_app_asj_2021.persistence.Task
import de.hdodenhof.circleimageview.CircleImageView

class Adapter(private val dataList:List<Task>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    // Represents a single row in a list
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize
        val icon:CircleImageView = itemView.findViewById(R.id.icon)
        val textView1: TextView = itemView.findViewById(R.id.task_name)
        val textView2: TextView = itemView.findViewById(R.id.task_desc)
        val check_box: CheckBox = itemView.findViewById(R.id.check_box)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.single_task, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]

        // setter
        holder.textView1.text = currentItem.task_name
        holder.textView2.text = currentItem.task_desc
        holder.icon.setImageResource(currentItem.icon)
        holder.check_box.isChecked = currentItem.isChecked
    }

    override fun getItemCount() = dataList.size
}