package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.deptofinfotechmobileapp.databinding.ActivityFacultyStaffDirectoryBinding

class FacultyStaffDirectory : AppCompatActivity() {

    private lateinit var binding: ActivityFacultyStaffDirectoryBinding
    private lateinit var staffArrayList: ArrayList<StaffDetails>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacultyStaffDirectoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val staffList = findViewById<ListView>(R.id.staffList)

        val staffphoto = intArrayOf(
            R.drawable.a,R.drawable.b,R.drawable.c, R.drawable.d,R.drawable.e
        )

        val staffname = arrayOf(
            "Henry Osborne","Muhammad Waqar Khan","Andrei Scott","Cecil White","Sirica Thomas"
        )
        val staffPNum = arrayOf(
            "123-456-7890","247-648-1264","564-668-2614","656-313-6584","846-240-2646"
        )
        val staffemail = arrayOf(
            "hosbourne@ucc.edu.jm","mwkhan@faculty.ucc.edu.jm","ascott@faculty.ucc.edu.jm","cwhite01@faculty.ucc.edu.jm",
            "sthomas@faculty.ucc.edu.jm"
        )

        staffArrayList = ArrayList()

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,staffname
        )

        staffList.isClickable = true
        staffList.adapter = arrayAdapter
        staffList.setOnItemClickListener{adapterview,view,position,l ->
            staffname[position]
            val I = Intent( this,DisplayStaff::class.java)
            I.putExtra("Image",staffphoto[position])
            I.putExtra("Name",staffname[position])
            I.putExtra("Email",staffemail[position])
            I.putExtra("Phone Number",staffPNum[position])
            startActivity(I)
        }
    }
}