package com.example.deptofinfotechmobileapp
// Michael Lee ID#20214626
// Iodre Paterson ID#20196143

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class Email_Everyone : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_everyone)

        val email = intent.getStringExtra("Email")
        val senderEmail = "Mikio@gmail.com"
        val sendEmailbtn = findViewById<Button>(R.id.sendEmailbtn)

        findViewById<TextView>(R.id.receivertextView).apply {
            text = email
        }

        findViewById<TextView>(R.id.sendertextView).apply {
            senderEmail
        }

        val subject = findViewById<EditText>(R.id.tyepsubjecteditText)
        val sendmsg = findViewById<EditText>(R.id.messageEditText)

        sendEmailbtn.setOnClickListener{
            val subject = subject.text.toString().trim()
            val sendmsg = sendmsg.text.toString().trim()

            val mIntent = Intent(Intent.ACTION_SEND)

            mIntent.data = Uri.parse("mailto:")
            mIntent.type = "text/plain"
            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            mIntent.putExtra(Intent.EXTRA_TEXT, sendmsg)

            try {
                startActivity(Intent.createChooser(mIntent,"Send Email"))
            }catch(e: Exception){
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }

        }



    }
}