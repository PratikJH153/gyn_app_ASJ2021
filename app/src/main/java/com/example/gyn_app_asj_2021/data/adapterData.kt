package com.example.gyn_app_asj_2021.data

import com.example.gyn_app_asj_2021.R
import com.example.gyn_app_asj_2021.persistence.Task

var dataList: MutableList<Task> = mutableListOf(
    Task(
        "Gym",
        "My daily gym routine",
        icon = R.drawable.ic_food,
        true
    ),
    Task(
        "Gym",
        "My daily gym routine",
        icon = R.drawable.ic_icon_1,
        false
    ),
    Task(
        "Gym",
        "My daily gym routine",
        icon = R.drawable.ic_icon_2,
        false
    ),
)