package com.example.gyn_app_asj_2021.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyn_app_asj_2021.R
import com.example.gyn_app_asj_2021.adapters.Adapter
import com.example.gyn_app_asj_2021.data.dataList
import com.google.android.material.floatingactionbutton.FloatingActionButton

class listFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view_list = inflater.inflate(R.layout.fragment_list, container, false)

        val recycler_view: RecyclerView = view_list.findViewById(R.id.recycler_view_list)
        recycler_view.adapter = Adapter(dataList)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.setHasFixedSize(true)
        // Inflate the layout for this fragment
        val button = view_list.findViewById<FloatingActionButton>(R.id.button1)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view_list
    }
}