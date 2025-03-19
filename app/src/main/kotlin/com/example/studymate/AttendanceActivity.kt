package com.example.studymate

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AttendanceActivity : AppCompatActivity() {

    private lateinit var markAttendanceButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        // Initialize the markAttendanceButton and set its click listener
        markAttendanceButton = findViewById(R.id.markAttendanceButton)
        markAttendanceButton.setOnClickListener {
            markAttendance()
        }
    }

    private fun markAttendance() {
        // Implement the functionality to mark attendance
        // For now, it just shows a toast message
        Toast.makeText(this, "Attendance marked successfully", Toast.LENGTH_SHORT).show()
    }
}
