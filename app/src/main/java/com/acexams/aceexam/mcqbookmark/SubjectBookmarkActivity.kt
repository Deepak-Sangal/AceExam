package com.acexams.aceexam.mcqbookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.mcqbookmark.adapter.SubjectBookmarkAdapter
import com.acexams.aceexam.mcqbookmark.modal.BookMarkListModal
import kotlinx.android.synthetic.main.activity_subject_bookmark.*

class SubjectBookmarkActivity : AppCompatActivity() {


     lateinit var booklist_detail:ArrayList<BookMarkListModal.Data.Questionbookmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_bookmark)
        booklist_detail= arrayListOf()
        booklist_detail= intent.getSerializableExtra("datalist") as ArrayList<BookMarkListModal.Data.Questionbookmark>


        sub_bookmark_back.setOnClickListener {
            onBackPressed()
        }

        sub_bookmark_recycler.layoutManager = LinearLayoutManager(this)
        sub_bookmark_recycler.adapter = SubjectBookmarkAdapter(this,booklist_detail)


    }
}