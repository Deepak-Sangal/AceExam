package com.acexams.aceexam.buynow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.activity_buy_now.*

class BuyNowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_now)

        buy_now_back.setOnClickListener {
            onBackPressed()
        }
    }
}