package com.acexams.aceexam.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import com.acexams.aceexam.TestActivity
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity() {
    var totalScore:String="0"
    var test_id:String="0"
    var user_id:String="0"
    var crt:String="0"
    var skp:String="0"
    var incr:String="0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        totalScore=intent.getStringExtra("data").toString()
        test_id=intent.getStringExtra("team_id").toString()
        user_id=intent.getStringExtra("user").toString()
        crt=intent.getStringExtra("correct").toString()
        incr=intent.getStringExtra("in_correct").toString()
        skp=intent.getStringExtra("skipped").toString()
        txt_result.text=totalScore+"% Percentile"

        txt_crt_ans.text= crt
        txt_incr_ansr.text=incr
        txt_skp.text=skp

        txt_back.setOnClickListener {
            var intent=Intent(this, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }
        tv_review.setOnClickListener{
                var intent=Intent(this,ReviewDetailsActivity::class.java)
                    intent.putExtra("test_id", test_id)
                 intent.putExtra("user", shareprefrences.getStringPreference(this, "USER_ID").toString())
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        var intent=Intent(this, DashBoardActivity::class.java)
        startActivity(intent)
        finish()
    }
}