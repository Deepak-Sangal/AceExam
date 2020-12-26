package com.acexams.aceexam.mcqbookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acexams.aceexam.R
import com.acexams.aceexam.mcqbookmark.modal.BookMarkListModal
import kotlinx.android.synthetic.main.activity_book_list_detail.*


class BookListDetailActivity : AppCompatActivity() {
    lateinit var booklist_detail:ArrayList<BookMarkListModal.Data.Questionbookmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list_detail)
        booklist_detail= intent.getSerializableExtra("datalist") as ArrayList<BookMarkListModal.Data.Questionbookmark>

        book_mark_list_question.text=booklist_detail[0].question.question
        booklist_answer_one.text="(A) "+booklist_detail[0].question.answers[0].options
        booklist_answer_two.text="(B) "+booklist_detail[0].question.answers[1].options
        booklist_answer_three.text="(C) "+booklist_detail[0].question.answers[2].options
        booklist_answer_four.text="(D) "+booklist_detail[0].question.answers[3].options
        explanition_book_list.text=booklist_detail[0].question.explaination

        lnr_bak.setOnClickListener {
            onBackPressed()
        }


    }
}