package com.acexams.aceexam.questiobank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.activity_new_custom_module.*

class NewCustomModule : AppCompatActivity() {

    var value="1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_custom_module)
        var intent=Intent()

        rel_exam_mode.setOnClickListener {
            img_exam.setImageResource(R.drawable.ic_all);
            img_regular.setImageResource(R.drawable.ic_unchecked);
            value="1"


        }


        rlv_regular_mode.setOnClickListener {
            img_exam.setImageResource(R.drawable.ic_unchecked);
            img_regular.setImageResource(R.drawable.ic_all);
            value="2"

        }

        bnt_next_test.setOnClickListener {
            startActivity(Intent(this,QuestionBankTestActivity::class.java))
        }

    }


}