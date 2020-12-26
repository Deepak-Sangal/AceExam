package com.acexams.aceexam.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.activity_year_selection.*

class YearSelectionActivity : AppCompatActivity(), View.OnClickListener {

    var year: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_year_selection)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        backbutton.setOnClickListener {
            onBackPressed()
        }
        txt_year_selection.setOnClickListener(this)
        second_year_selection.setOnClickListener(this)
        third_year_selection.setOnClickListener(this)
        fourth_year_selection.setOnClickListener(this)
        doctor.setOnClickListener(this)
        bnt_confirm.setOnClickListener(this)

//        bnt_confirm.setOnClickListener {
//            startActivity(Intent(this,StateSelectionActivity::class.java))
//        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.txt_year_selection -> {
                year = "selected"
                shareprefrences.setStringPreference(this, "yearid", "1")
                txt_year_selection.background = resources.getDrawable(R.color.common)
                second_year_selection.background = resources.getDrawable(R.color.white)
                third_year_selection.background = resources.getDrawable(R.color.white)
                fourth_year_selection.background = resources.getDrawable(R.color.white)
                doctor.background = resources.getDrawable(R.color.white)
            }
            R.id.second_year_selection -> {
                year = "selected"
                shareprefrences.setStringPreference(this, "yearid", "2")
                txt_year_selection.background = resources.getDrawable(R.color.white)
                second_year_selection.background = resources.getDrawable(R.color.common)
                third_year_selection.background = resources.getDrawable(R.color.white)
                fourth_year_selection.background = resources.getDrawable(R.color.white)
                doctor.background = resources.getDrawable(R.color.white)

            }
            R.id.third_year_selection -> {
                year = "selected"
                shareprefrences.setStringPreference(this, "yearid", "3")
                txt_year_selection.background = resources.getDrawable(R.color.white)
                second_year_selection.background = resources.getDrawable(R.color.white)
                third_year_selection.background = resources.getDrawable(R.color.common)
                fourth_year_selection.background = resources.getDrawable(R.color.white)
                doctor.background = resources.getDrawable(R.color.white)
            }
            R.id.fourth_year_selection -> {
                year = "selected"
                shareprefrences.setStringPreference(this, "yearid", "4")
                txt_year_selection.background = resources.getDrawable(R.color.white)
                second_year_selection.background = resources.getDrawable(R.color.white)
                third_year_selection.background = resources.getDrawable(R.color.white)
                fourth_year_selection.background = resources.getDrawable(R.color.common)
                doctor.background = resources.getDrawable(R.color.white)

            }
            R.id.doctor -> {
                year = "selected"
                shareprefrences.setStringPreference(this, "yearid", "5")
                shareprefrences.setStringPreference(this, "yearid", "4")
                txt_year_selection.background = resources.getDrawable(R.color.white)
                second_year_selection.background = resources.getDrawable(R.color.white)
                third_year_selection.background = resources.getDrawable(R.color.white)
                fourth_year_selection.background = resources.getDrawable(R.color.white)
                doctor.background = resources.getDrawable(R.color.common)

            }

            R.id.bnt_confirm -> {
                nextacivity()
            }
        }
    }


    fun nextacivity() {
        if (year.trim().isEmpty()) {
            Toast.makeText(this, "Please Select Year", Toast.LENGTH_SHORT).show()
        } else {
            startActivity(Intent(this, StateSelectionActivity::class.java))
        }

    }
}