package com.example.todoapp

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao){

    val alltodos: LiveData<List<Todo>> = todoDao.getAllTodos()

    suspend fun insert(todo: Todo){
        todoDao.insert(todo)
    }

    suspend fun delete(todo: Todo){
        todoDao.delete(todo)
    }

    suspend fun update(todo: Todo){
        todoDao.update(todo)
    }
}