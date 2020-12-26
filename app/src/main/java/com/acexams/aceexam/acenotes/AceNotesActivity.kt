package com.acexams.aceexam.acenotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.activity_ace_notes.*

class AceNotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ace_notes)

        ace_notes_back.setOnClickListener {
            onBackPressed()
        }
    }
}