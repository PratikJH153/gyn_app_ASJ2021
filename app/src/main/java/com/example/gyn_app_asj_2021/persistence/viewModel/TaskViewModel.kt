package com.example.gyn_app_asj_2021.persistence.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.gyn_app_asj_2021.persistence.Task
import com.example.gyn_app_asj_2021.persistence.TaskDatabase
import com.example.gyn_app_asj_2021.persistence.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application){

    val allTasks: LiveData<List<Task>>
    val repository: TaskRepository

    init {
        val dao = TaskDatabase.getDatabase(application).getTasksDao()
        repository = TaskRepository(dao)
        allTasks = repository.allTasks
    }

    fun deleteTask(task:Task) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(task)
    }

    fun updateNote(task:Task) = viewModelScope.launch(Dispatchers.IO){
        repository.update(task)
    }
    
    fun addNote(task:Task) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(task)
    }

}