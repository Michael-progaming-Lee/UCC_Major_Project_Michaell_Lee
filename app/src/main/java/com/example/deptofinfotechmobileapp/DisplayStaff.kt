package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class DisplayStaff : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_staff)

        val callbtn     = findViewById<ImageButton>(R.id.callbtn)
        val emailbtn    = findViewById<ImageButton>(R.id.emailstaffbtn)

        val image = intent.getIntExtra("Image",R.drawable.a)
        val name = intent.getStringExtra("Name")
        val pnum = intent.getStringExtra("Phone Number")
        val email = intent.getStringExtra("Email")

        //Display Image
        val imageView = findViewById<ImageView>(R.id.staffimageView)
        imageView.setImageResource(image)

        findViewById<TextView>(R.id.staffNameView).apply {
            text = name
        }

        findViewById<TextView>(R.id.staffEmailView).apply {
            text = email
        }
        findViewById<TextView>(R.id.staffPNumView).apply {
            text = pnum
        }

        callpermission()

        callbtn.setOnClickListener{
            dialstaffnum(pnum)
        }
        emailbtn.setOnClickListener{
            val I = Intent( this,Email_Everyone::class.java)
            I.putExtra("Email",email)
            startActivity(I)
        }
    }

    private fun dialstaffnum(pnum: String?) {
        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$pnum"))
        startActivity(dialIntent)
    }

    private fun callpermission(){
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),101)
        }
    }
}