package com.example.gyn_app_asj_2021.persistence

import androidx.lifecycle.LiveData

class TaskRepository(private val tasksDao: TaskDao){

    val allTasks: LiveData<List<Task>> = tasksDao.getAllTasks()

    suspend fun insert(task:Task){
        tasksDao.insert(task)
    }

    suspend fun delete(task:Task){
        tasksDao.delete(task)
    }

    suspend fun update(task:Task){
        tasksDao.update(task)
    }

}