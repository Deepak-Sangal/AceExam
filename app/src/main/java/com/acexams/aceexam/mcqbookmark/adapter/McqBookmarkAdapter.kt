package com.acexams.aceexam.mcqbookmark.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.mcqbookmark.SubjectBookmarkActivity
import com.acexams.aceexam.mcqbookmark.modal.BookMarkListModal
import kotlinx.android.synthetic.main.adapter_mcq_bookmarks.view.*

class McqBookmarkAdapter(var context: Context,
                         var booklist:ArrayList<BookMarkListModal.Data>
) : RecyclerView.Adapter<McqBookmarkAdapter.BookmarkHolder>() {
    inner class BookmarkHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.bookmark_subject_arrow.setOnClickListener {
                context.startActivity(Intent(context,SubjectBookmarkActivity::class.java).putExtra("datalist",booklist[adapterPosition].questionbookmark))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.adapter_mcq_bookmarks,parent,false)
        return BookmarkHolder(view)
    }

    override fun onBindViewHolder(holder: BookmarkHolder, position: Int) {
        holder.itemView.bookmark_subject.text = booklist[position].title
        holder.itemView.bookmark_subject_count.text = " ("+booklist[position].no_question.toString()+")"
    }

    override fun getItemCount(): Int {
        return booklist.size
    }
}