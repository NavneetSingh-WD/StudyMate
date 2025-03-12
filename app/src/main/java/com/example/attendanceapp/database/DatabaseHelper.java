package com.example.attendanceapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "attendanceApp.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    public static final String TABLE_ATTENDANCE = "attendance";
    public static final String TABLE_TASKS = "tasks";
    public static final String TABLE_STUDY_MATERIAL = "study_material";

    // Common column names
    public static final String COLUMN_ID = "id";

    // Attendance table columns
    public static final String COLUMN_ATTENDANCE_DATE = "date";
    public static final String COLUMN_ATTENDANCE_STATUS = "status";

    // Tasks table columns
    public static final String COLUMN_TASK_TITLE = "title";
    public static final String COLUMN_TASK_DESCRIPTION = "description";
    public static final String COLUMN_TASK_DUE_DATE = "due_date";

    // Study material table columns
    public static final String COLUMN_STUDY_MATERIAL_TITLE = "title";
    public static final String COLUMN_STUDY_MATERIAL_CONTENT = "content";

    // Create table statements
    private static final String CREATE_TABLE_ATTENDANCE = "CREATE TABLE " + TABLE_ATTENDANCE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_ATTENDANCE_DATE + " TEXT,"
            + COLUMN_ATTENDANCE_STATUS + " TEXT" + ")";

    private static final String CREATE_TABLE_TASKS = "CREATE TABLE " + TABLE_TASKS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_TASK_TITLE + " TEXT,"
            + COLUMN_TASK_DESCRIPTION + " TEXT,"
            + COLUMN_TASK_DUE_DATE + " TEXT" + ")";

    private static final String CREATE_TABLE_STUDY_MATERIAL = "CREATE TABLE " + TABLE_STUDY_MATERIAL + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_STUDY_MATERIAL_TITLE + " TEXT,"
            + COLUMN_STUDY_MATERIAL_CONTENT + " TEXT" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ATTENDANCE);
        db.execSQL(CREATE_TABLE_TASKS);
        db.execSQL(CREATE_TABLE_STUDY_MATERIAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDY_MATERIAL);
        onCreate(db);
    }

    // CRUD operations for Attendance table
    public void addAttendance(String date, String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ATTENDANCE_DATE, date);
        values.put(COLUMN_ATTENDANCE_STATUS, status);
        db.insert(TABLE_ATTENDANCE, null, values);
        db.close();
    }

    public Cursor getAllAttendance() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_ATTENDANCE, null, null, null, null, null, null);
    }

    public void updateAttendance(int id, String date, String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ATTENDANCE_DATE, date);
        values.put(COLUMN_ATTENDANCE_STATUS, status);
        db.update(TABLE_ATTENDANCE, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteAttendance(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ATTENDANCE, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // CRUD operations for Tasks table
    public void addTask(String title, String description, String dueDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASK_TITLE, title);
        values.put(COLUMN_TASK_DESCRIPTION, description);
        values.put(COLUMN_TASK_DUE_DATE, dueDate);
        db.insert(TABLE_TASKS, null, values);
        db.close();
    }

    public Cursor getAllTasks() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_TASKS, null, null, null, null, null, null);
    }

    public void updateTask(int id, String title, String description, String dueDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASK_TITLE, title);
        values.put(COLUMN_TASK_DESCRIPTION, description);
        values.put(COLUMN_TASK_DUE_DATE, dueDate);
        db.update(TABLE_TASKS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteTask(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASKS, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // CRUD operations for Study Material table
    public void addStudyMaterial(String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STUDY_MATERIAL_TITLE, title);
        values.put(COLUMN_STUDY_MATERIAL_CONTENT, content);
        db.insert(TABLE_STUDY_MATERIAL, null, values);
        db.close();
    }

    public Cursor getAllStudyMaterials() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_STUDY_MATERIAL, null, null, null, null, null, null);
    }

    public void updateStudyMaterial(int id, String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STUDY_MATERIAL_TITLE, title);
        values.put(COLUMN_STUDY_MATERIAL_CONTENT, content);
        db.update(TABLE_STUDY_MATERIAL, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteStudyMaterial(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDY_MATERIAL, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }
}
