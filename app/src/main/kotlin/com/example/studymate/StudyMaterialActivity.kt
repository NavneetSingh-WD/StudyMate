package com.example.studymate

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studymate.database.DatabaseHelper

class StudyMaterialActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudyMaterialAdapter
    private lateinit var editTextTitle: EditText
    private lateinit var editTextContent: EditText
    private lateinit var buttonAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_material)

        databaseHelper = DatabaseHelper(this)
        recyclerView = findViewById(R.id.recyclerView)
        editTextTitle = findViewById(R.id.editTextTitle)
        editTextContent = findViewById(R.id.editTextContent)
        buttonAdd = findViewById(R.id.buttonAdd)

        recyclerView.layoutManager = LinearLayoutManager(this)
        loadStudyMaterials()

        buttonAdd.setOnClickListener {
            addStudyMaterial()
        }
    }

    private fun loadStudyMaterials() {
        // Load all study materials from the database
        val studyMaterials = databaseHelper.getAllStudyMaterials()
        // Set up the adapter with the study materials
        adapter = StudyMaterialAdapter(studyMaterials)
        // Attach the adapter to the RecyclerView
        recyclerView.adapter = adapter
    }

    private fun addStudyMaterial() {
        val title = editTextTitle.text.toString().trim()
        val content = editTextContent.text.toString().trim()

        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Please enter both title and content", Toast.LENGTH_SHORT).show()
            return
        }

        // Create a new study material object
        val studyMaterial = StudyMaterial(title, content)
        // Add the study material to the database
        databaseHelper.addStudyMaterial(studyMaterial)
        // Reload the study materials to update the RecyclerView
        loadStudyMaterials()
        // Clear the input fields
        editTextTitle.setText("")
        editTextContent.setText("")
        Toast.makeText(this, "Study material added", Toast.LENGTH_SHORT).show()
    }
}
