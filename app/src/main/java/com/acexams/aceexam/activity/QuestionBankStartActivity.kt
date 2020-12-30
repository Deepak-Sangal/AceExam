package com.acexams.aceexam.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.acexams.aceexam.R
import com.acexams.aceexam.questiobank.QuestionTestActivity
import kotlinx.android.synthetic.main.activity_question_bank_start.*

class QuestionBankStartActivity : AppCompatActivity() {
    var id:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_bank_start)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        id= intent.getStringExtra("topicid").toString()
        questionis.text=shareprefrences.getStringPreference(this,"questioncount") + " Question"
        vbdfdsx.text=shareprefrences.getStringPreference(this,"topicname")
        dvsbdsfdf.text= "question Bank"+" - " +shareprefrences.getStringPreference(this,"dfdfdfdfdfd")
        backbutton_question.setOnClickListener {
            onBackPressed()
        }
        startsloving.setOnClickListener {
            if (shareprefrences.getStringPreference(this, "questioncount") != "0"){
            var intent = Intent(this, QuestionTestActivity::class.java)
            intent.putExtra("topicid", id)
            startActivity(intent)
        }else{
            Toast.makeText(this,"No Question Plz try Another Topic",Toast.LENGTH_SHORT).show()
            }
        }

    }
}