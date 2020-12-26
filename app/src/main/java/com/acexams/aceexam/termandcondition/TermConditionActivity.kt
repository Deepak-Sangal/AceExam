
package com.acexams.aceexam.termandcondition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.activity_term_condition.*

class TermConditionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_term_condition)

        terms_back.setOnClickListener {
            onBackPressed()
        }

        pdf_view_terms.fromAsset("terms.pdf").load()
    }
}