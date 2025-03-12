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

    fun openAttendance(view: View) {
        val intent = Intent(this, AttendanceActivity::class.java)
        startActivity(intent)
    }

    fun openTaskManager(view: View) {
        val intent = Intent(this, TaskManagerActivity::class.java)
        startActivity(intent)
    }

    fun openStudyMaterial(view: View) {
        val intent = Intent(this, StudyMaterialActivity::class.java)
        startActivity(intent)
    }

    fun openChat(view: View) {
        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)
    }

    fun openAIChatbot(view: View) {
        val intent = Intent(this, AIChatbotActivity::class.java)
        startActivity(intent)
    }
}
