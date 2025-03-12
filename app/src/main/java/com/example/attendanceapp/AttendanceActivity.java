package com.example.attendanceapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AttendanceActivity extends AppCompatActivity {

    private Button markAttendanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        markAttendanceButton = findViewById(R.id.markAttendanceButton);
        markAttendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markAttendance();
            }
        });
    }

    private void markAttendance() {
        // Implement the functionality to mark attendance
        Toast.makeText(this, "Attendance marked successfully", Toast.LENGTH_SHORT).show();
    }
}
