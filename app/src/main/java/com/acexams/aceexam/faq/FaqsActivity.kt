package com.acexams.aceexam.faq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.faq.adpater.FaqsGridAdapter
import com.acexams.aceexam.faq.adpater.FarAdpater
import kotlinx.android.synthetic.main.activity_faqs.*

class FaqsActivity : AppCompatActivity() {
    lateinit var farAdpater:FarAdpater
    var expend : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqs)

        var faqData: Array<String> =
            arrayOf("First Question", "Second Question", "Third Question", "Fourth Question")
        var faqData2: Array<String> =
            arrayOf("First Answer", "Second Answer", "Third Answer", "Fourth Answer")

        faqs_back.setOnClickListener {
            onBackPressed()
        }
        faqs_recycler_view.layoutManager = LinearLayoutManager(this)
        faqs_recycler_view.adapter = FarAdpater(this, faqData, faqData2)

        var faqsName: Array<String> = arrayOf(
            "QBank modules",
            "Video",
            "Subscription & Refund",
            "General Question",
            "Acexam Notes",
            "Help & Support",
            "Test Series"
        )
        var playerImages: IntArray = intArrayOf(
            R.drawable.question_bank,
            R.drawable.video,
            R.drawable.refund,
            R.drawable.general_knowledge,
            R.drawable.notes,
            R.drawable.help,
            R.drawable.test_series
        )

        faqs_grid.adapter = FaqsGridAdapter(this, faqsName, playerImages,expend)

        faqs_expend.setOnClickListener {
            if (expend == 0){
                expend = 1
                faqs_expend.text = "View Less"
                faqs_grid.adapter = FaqsGridAdapter(this, faqsName, playerImages,expend)

            }else{
                expend = 0
                faqs_expend.text = "View All"
                faqs_grid.adapter = FaqsGridAdapter(this, faqsName, playerImages,expend)
            }

        }
    }
}