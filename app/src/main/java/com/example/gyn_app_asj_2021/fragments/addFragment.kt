package com.example.gyn_app_asj_2021.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.gyn_app_asj_2021.R
import com.example.gyn_app_asj_2021.Task
import com.example.gyn_app_asj_2021.data.dataList
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*

class addFragment : Fragment() {

    var counter: Int = 0

    val drawable_list: List<Int> = listOf(
        R.drawable.coffeebreak,
        R.drawable.dish,
        R.drawable.dumbbel,
        R.drawable.fastfood,
        R.drawable.fork,
        R.drawable.run,
        R.drawable.sunbed,
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view_list = inflater.inflate(R.layout.fragment_add, container, false)
        val button = view_list.findViewById<Button>(R.id.ok_button_add)
        val icon = view_list.findViewById<CircleImageView>(R.id.icon_add_fragment)
        val task_tf = view_list.findViewById<EditText>(R.id.task_name_edit_text)
        val desc_tf = view_list.findViewById<EditText>(R.id.desc_name_edit_text)

        icon.setOnClickListener {
            if (counter >= drawable_list.size - 1) {
                counter = 0
            } else {
                counter++
            }

            icon.setImageResource(drawable_list[counter])
        }

        button.setOnClickListener {
            if (task_tf.text.toString().trim().isEmpty()) {
                Toast.makeText(activity, "Enter valid details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newTask: Task =
                Task(
                    task_tf.text.toString(),
                    desc_tf.text.toString(),
                    drawable_list[counter],
                    true)

            dataList.add(newTask)

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

        return view_list
    }
}