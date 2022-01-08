package com.example.gyn_app_asj_2021.persistence

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task:Task)

    @Update
    suspend fun update(task:Task)

    @Delete
    suspend fun delete(task:Task)

    @Query("Select * from task_table order by id asc")
    fun getAllTasks():LiveData<List<Task>>

}