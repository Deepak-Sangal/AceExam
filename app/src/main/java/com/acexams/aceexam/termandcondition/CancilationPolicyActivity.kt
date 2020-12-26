package com.acexams.aceexam.termandcondition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.activity_cancilation_policy.*

class CancilationPolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancilation_policy)

        cancellation_back.setOnClickListener {
            onBackPressed()
        }

        pdf_view_cancellation.fromAsset("cancellationpolicy.pdf").load()
    }
}