package com.example.gyn_app_asj_2021.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
class Task(
    @ColumnInfo(name = "name")
    var task_name:String,

    @ColumnInfo(name = "desc")
    var task_desc:String,

    @ColumnInfo(name = "icon")
    var icon:Int,

    @ColumnInfo(name = "isDone")
    var isChecked:Boolean,

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)