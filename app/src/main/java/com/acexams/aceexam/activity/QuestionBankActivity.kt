package com.acexams.aceexam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.QbanksubjectResponse
import com.acexams.aceexam.adapter.QuestionBankAdapter
import kotlinx.android.synthetic.main.activity_question_bank.*

class QuestionBankActivity : AppCompatActivity() {
    var datalist:ArrayList<QbanksubjectResponse.Data.Chapter> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_bank)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        if (intent.extras!=null){
            datalist= intent.getSerializableExtra("datalist") as ArrayList<QbanksubjectResponse.Data.Chapter>
        }

        questionbak.layoutManager= LinearLayoutManager(this)
        questionbak.adapter=QuestionBankAdapter(this,datalist)
        backbutton.setOnClickListener {
            onBackPressed()
        }
    }
}