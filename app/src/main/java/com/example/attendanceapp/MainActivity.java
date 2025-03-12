package com.example.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAttendance(View view) {
        Intent intent = new Intent(this, AttendanceActivity.class);
        startActivity(intent);
    }

    public void openTaskManager(View view) {
        Intent intent = new Intent(this, TaskManagerActivity.class);
        startActivity(intent);
    }

    public void openStudyMaterial(View view) {
        Intent intent = new Intent(this, StudyMaterialActivity.class);
        startActivity(intent);
    }

    public void openChat(View view) {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

    public void openAIChatbot(View view) {
        Intent intent = new Intent(this, AIChatbotActivity.class);
        startActivity(intent);
    }
}
