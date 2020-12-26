package com.acexams.aceexam.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.CourseSelectionActivity
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {
    lateinit var password: String
    lateinit var email: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_name)
        password = intent.getStringExtra("password").toString()
        email = intent.getStringExtra("email").toString()
        nameback.setOnClickListener {
            onBackPressed()
        }
        btn_name.setOnClickListener {
            if (name.text.isEmpty()) {
                name.requestFocus()
                name.error = "Enter Name"
            } else {
                shareprefrences.setStringPreference(this,"password",password)
                shareprefrences.setStringPreference(this,"email",email)
                shareprefrences.setStringPreference(this,"name",name.text.toString())
                startActivity(Intent(this@NameActivity, CourseSelectionActivity::class.java))
            }


        }
    }



}