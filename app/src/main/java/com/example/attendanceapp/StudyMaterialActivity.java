package com.example.attendanceapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.attendanceapp.database.DatabaseHelper;
import java.util.List;

public class StudyMaterialActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private StudyMaterialAdapter adapter;
    private EditText editTextTitle;
    private EditText editTextContent;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_material);

        databaseHelper = new DatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerView);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        buttonAdd = findViewById(R.id.buttonAdd);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadStudyMaterials();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudyMaterial();
            }
        });
    }

    private void loadStudyMaterials() {
        List<StudyMaterial> studyMaterials = databaseHelper.getAllStudyMaterials();
        adapter = new StudyMaterialAdapter(studyMaterials);
        recyclerView.setAdapter(adapter);
    }

    private void addStudyMaterial() {
        String title = editTextTitle.getText().toString().trim();
        String content = editTextContent.getText().toString().trim();

        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Please enter both title and content", Toast.LENGTH_SHORT).show();
            return;
        }

        StudyMaterial studyMaterial = new StudyMaterial(title, content);
        databaseHelper.addStudyMaterial(studyMaterial);
        loadStudyMaterials();
        editTextTitle.setText("");
        editTextContent.setText("");
        Toast.makeText(this, "Study material added", Toast.LENGTH_SHORT).show();
    }
}
