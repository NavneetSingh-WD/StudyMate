package com.example.attendanceapp

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

        markAttendanceButton = findViewById(R.id.markAttendanceButton)
        markAttendanceButton.setOnClickListener {
            markAttendance()
        }
    }

    private fun markAttendance() {
        // Implement the functionality to mark attendance
        Toast.makeText(this, "Attendance marked successfully", Toast.LENGTH_SHORT).show()
    }
}
