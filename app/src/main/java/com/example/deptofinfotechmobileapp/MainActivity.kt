package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val staffbtn = findViewById<Button>(R.id.staffBtn)
        val coursebtn = findViewById<Button>(R.id.coursesBtn)
        val admissionsbtn = findViewById<Button>(R.id.admissionsBtn)
        val socialbtn = findViewById<Button>(R.id.socialBtn)
        val emailFABtn = findViewById<FloatingActionButton>(R.id.emailFABtn)

        staffbtn.setOnClickListener{
            val intent = Intent(this, FacultyStaffDirectory::class.java)
            startActivity(intent)
        }

        coursebtn.setOnClickListener{
            val intent = Intent(this, Courses::class.java)
            startActivity(intent)
        }

        admissionsbtn.setOnClickListener{
            val intent = Intent(this, Admissions::class.java)
            startActivity(intent)
        }

        socialbtn.setOnClickListener{
            val intent = Intent(this, SocialMedia::class.java)
            startActivity(intent)
        }

        emailFABtn.setOnClickListener{
            val emailHOD = "itfaculty@ucc.edu.jm"
            val intent = Intent(this, Email_Everyone::class.java)
            intent.putExtra("Email", emailHOD)
            startActivity(intent)
        }


    }
}