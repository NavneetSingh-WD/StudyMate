package com.example.studymate.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_ATTENDANCE)
        db.execSQL(CREATE_TABLE_TASKS)
        db.execSQL(CREATE_TABLE_STUDY_MATERIAL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ATTENDANCE")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_TASKS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_STUDY_MATERIAL")
        onCreate(db)
    }

    // CRUD operations for Attendance table
    fun addAttendance(date: String, status: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ATTENDANCE_DATE, date)
        values.put(COLUMN_ATTENDANCE_STATUS, status)
        db.insert(TABLE_ATTENDANCE, null, values)
        db.close()
    }

    fun getAllAttendance(): Cursor {
        val db = this.readableDatabase
        return db.query(TABLE_ATTENDANCE, null, null, null, null, null, null)
    }

    fun updateAttendance(id: Int, date: String, status: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ATTENDANCE_DATE, date)
        values.put(COLUMN_ATTENDANCE_STATUS, status)
        db.update(TABLE_ATTENDANCE, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
    }

    fun deleteAttendance(id: Int) {
        val db = this.writableDatabase
        db.delete(TABLE_ATTENDANCE, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
    }

    // CRUD operations for Tasks table
    fun addTask(title: String, description: String, dueDate: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TASK_TITLE, title)
        values.put(COLUMN_TASK_DESCRIPTION, description)
        values.put(COLUMN_TASK_DUE_DATE, dueDate)
        db.insert(TABLE_TASKS, null, values)
        db.close()
    }

    fun getAllTasks(): Cursor {
        val db = this.readableDatabase
        return db.query(TABLE_TASKS, null, null, null, null, null, null)
    }

    fun updateTask(id: Int, title: String, description: String, dueDate: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TASK_TITLE, title)
        values.put(COLUMN_TASK_DESCRIPTION, description)
        values.put(COLUMN_TASK_DUE_DATE, dueDate)
        db.update(TABLE_TASKS, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
    }

    fun deleteTask(id: Int) {
        val db = this.writableDatabase
        db.delete(TABLE_TASKS, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
    }

    // CRUD operations for Study Material table
    fun addStudyMaterial(title: String, content: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_STUDY_MATERIAL_TITLE, title)
        values.put(COLUMN_STUDY_MATERIAL_CONTENT, content)
        db.insert(TABLE_STUDY_MATERIAL, null, values)
        db.close()
    }

    fun getAllStudyMaterials(): Cursor {
        val db = this.readableDatabase
        return db.query(TABLE_STUDY_MATERIAL, null, null, null, null, null, null)
    }

    fun updateStudyMaterial(id: Int, title: String, content: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_STUDY_MATERIAL_TITLE, title)
        values.put(COLUMN_STUDY_MATERIAL_CONTENT, content)
        db.update(TABLE_STUDY_MATERIAL, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
    }

    fun deleteStudyMaterial(id: Int) {
        val db = this.writableDatabase
        db.delete(TABLE_STUDY_MATERIAL, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
    }

    companion object {
        private const val DATABASE_NAME = "attendanceApp.db"
        private const val DATABASE_VERSION = 1

        // Table names
        const val TABLE_ATTENDANCE = "attendance"
        const val TABLE_TASKS = "tasks"
        const val TABLE_STUDY_MATERIAL = "study_material"

        // Common column names
        const val COLUMN_ID = "id"

        // Attendance table columns
        const val COLUMN_ATTENDANCE_DATE = "date"
        const val COLUMN_ATTENDANCE_STATUS = "status"

        // Tasks table columns
        const val COLUMN_TASK_TITLE = "title"
        const val COLUMN_TASK_DESCRIPTION = "description"
        const val COLUMN_TASK_DUE_DATE = "due_date"

        // Study material table columns
        const val COLUMN_STUDY_MATERIAL_TITLE = "title"
        const val COLUMN_STUDY_MATERIAL_CONTENT = "content"

        // Create table statements
        private const val CREATE_TABLE_ATTENDANCE = "CREATE TABLE $TABLE_ATTENDANCE (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_ATTENDANCE_DATE TEXT, " +
                "$COLUMN_ATTENDANCE_STATUS TEXT)"

        private const val CREATE_TABLE_TASKS = "CREATE TABLE $TABLE_TASKS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_TASK_TITLE TEXT, " +
                "$COLUMN_TASK_DESCRIPTION TEXT, " +
                "$COLUMN_TASK_DUE_DATE TEXT)"

        private const val CREATE_TABLE_STUDY_MATERIAL = "CREATE TABLE $TABLE_STUDY_MATERIAL (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_STUDY_MATERIAL_TITLE TEXT, " +
                "$COLUMN_STUDY_MATERIAL_CONTENT TEXT)"
    }
}
