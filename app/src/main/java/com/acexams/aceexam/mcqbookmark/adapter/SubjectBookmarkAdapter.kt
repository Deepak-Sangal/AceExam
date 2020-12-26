package com.acexams.aceexam.mcqbookmark.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.mcqbookmark.BookListDetailActivity
import com.acexams.aceexam.mcqbookmark.modal.BookMarkListModal
import kotlinx.android.synthetic.main.adapter_subject_bookmark.view.*

class SubjectBookmarkAdapter(var context: Context,
                             var booklist:ArrayList<BookMarkListModal.Data.Questionbookmark>)
    : RecyclerView.Adapter<SubjectBookmarkAdapter.SubjectHolder>() {

    inner class SubjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_subject_bookmark,parent,false)
        return SubjectHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {
        var data=position+1
        holder.itemView.txt_count.text= "($data) "
        holder.itemView.subj_question.text =booklist[position].question.question
    //    holder.itemView.subj_name.text = booklist[position].count

        holder.itemView.rel_detail_bookmar.setOnClickListener {
            context.startActivity(Intent(context, BookListDetailActivity::class.java).putExtra("datalist",booklist))

        }
    }

    override fun getItemCount(): Int {
        return booklist.size
    }

}