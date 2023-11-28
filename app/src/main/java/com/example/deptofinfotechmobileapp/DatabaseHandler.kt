package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "CoursesDatabase"
        private const val TABLE_NAME = "courses"

        private const val KEY_CODE = "code"
        private const val KEY_NAME = "name"
        private const val KEY_CREDITS = "credits"
        private const val KEY_PREREQUISITES = "prerequisites"
        private const val KEY_DESCRIPTION = "description"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $KEY_CODE TEXT PRIMARY KEY,
                $KEY_NAME TEXT,
                $KEY_CREDITS INTEGER,
                $KEY_PREREQUISITES TEXT,
                $KEY_DESCRIPTION TEXT
            )
        """.trimIndent()
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addCourse(course: Course) {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(KEY_CODE, course.code)
        values.put(KEY_NAME, course.name)
        values.put(KEY_CREDITS, course.credits)
        values.put(KEY_PREREQUISITES, course.prerequisites)
        values.put(KEY_DESCRIPTION, course.description)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllCourses(): List<Course> {
        val courses = mutableListOf<Course>()
        val query = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase

        val cursor: Cursor? = db.rawQuery(query, null)
        cursor?.use {
            if (it.moveToFirst()) {
                do {
                    val code = it.getString(it.getColumnIndex(KEY_CODE))
                    val name = it.getString(it.getColumnIndex(KEY_NAME))
                    val credits = it.getInt(it.getColumnIndex(KEY_CREDITS))
                    val prerequisites = it.getString(it.getColumnIndex(KEY_PREREQUISITES))
                    val description = it.getString(it.getColumnIndex(KEY_DESCRIPTION))

                    val course = Course(code, name, credits, prerequisites, description)
                    courses.add(course)
                } while (it.moveToNext())
            }
        }

        cursor?.close()
        db.close()

        return courses
    }
}
