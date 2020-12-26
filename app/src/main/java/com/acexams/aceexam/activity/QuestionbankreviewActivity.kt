package com.acexams.aceexam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.activity_questionbankreview.*

class QuestionbankreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionbankreview)
        txt_crt_ans.text=intent.getStringExtra("current").toString()
        txt_incr_ansr.text=intent.getStringExtra("wrong").toString()
        txt_back.setOnClickListener{
            onBackPressed()
        }
    }
}