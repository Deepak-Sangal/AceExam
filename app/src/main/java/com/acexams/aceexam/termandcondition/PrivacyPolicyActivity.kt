package com.acexams.aceexam.termandcondition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.activity_privacy_policy.*

class PrivacyPolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_policy)

        pdf_view_privacy.fromAsset("privacypolicy.pdf")
    }
}