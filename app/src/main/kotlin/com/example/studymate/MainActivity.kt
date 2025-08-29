package com.example.studymate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    // Function to open the AttendanceActivity
    fun openAttendance(view: View) {
        // Create an intent to start the AttendanceActivity
        val intent = Intent(this, AttendanceActivity::class.java)
        // Start the activity
        startActivity(intent)
    }

    // Function to open the TaskManagerActivity
    fun openTaskManager(view: View) {
        // Create an intent to start the TaskManagerActivity
        val intent = Intent(this, TaskManagerActivity::class.java)
        // Start the activity
        startActivity(intent)
    }

    // Function to open the StudyMaterialActivity
    fun openStudyMaterial(view: View) {
        // Create an intent to start the StudyMaterialActivity
        val intent = Intent(this, StudyMaterialActivity::class.java)
        // Start the activity
        startActivity(intent)
    }

    // Function to open the ChatActivity
    fun openChat(view: View) {
        // Create an intent to start the ChatActivity
        val intent = Intent(this, ChatActivity::class.java)
        // Start the activity
        startActivity(intent)
    }

    // Function to open the AIChatbotActivity
    fun openAIChatbot(view: View) {
        // Create an intent to start the AIChatbotActivity
        val intent = Intent(this, AIChatbotActivity::class.java)
        // Start the activity
        startActivity(intent)
    }
}
