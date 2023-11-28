package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Admissions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        val applybtn = findViewById<Button>(R.id.applybtn)

        val admission = "To be unconditionally admitted to complete UCC undergraduate programmes, " +
                "individuals should possess a minimum of five (5) subjects at the GCE or CSEC level " +
                "(including the mandatory English Language and Mathematics) at grades A, B, C or 1, " +
                "2, 3 respectively. A CSEC pass at level 3 must have been obtained since 1998."

        val admissionview = findViewById<TextView>(R.id.admissionReqView).apply {
            text = admission
        }

        applybtn.setOnClickListener{
            val intent = Intent(this, Apply_for_admission::class.java)
            startActivity(intent)
        }

    }
}