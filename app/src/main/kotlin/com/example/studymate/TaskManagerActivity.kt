package com.example.studymate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskManagerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskList: MutableList<Task>
    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_manager)

        recyclerView = findViewById(R.id.recyclerViewTasks)
        fabAddTask = findViewById(R.id.fabAddTask)

        // Initialize the task list and task adapter
        taskList = mutableListOf()
        taskAdapter = TaskAdapter(taskList)

        // Set up the RecyclerView with a LinearLayoutManager and the task adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

        // Set the click listener for the floating action button
        fabAddTask.setOnClickListener {
            // Implement the functionality to add a new task
            // For now, we will just add a dummy task
            val newTask = Task("New Task", "Task description", "Due date")
            taskList.add(newTask)
            taskAdapter.notifyDataSetChanged()
        }
    }
}
