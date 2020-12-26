package com.acexams.aceexam.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.acexams.aceexam.R
import com.acexams.aceexam.activity.StartExamActivity

import com.acexams.aceexam.activity.modal.TestexamResponse

import kotlinx.android.synthetic.main.adpter_exam.view.*


class ExamAdapter(var context: Context, var examlist: List<TestexamResponse.Data>) :
    RecyclerView.Adapter<ExamAdapter.Classessholder>() {
    lateinit var token: String

    inner class Classessholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.clickexam.setOnClickListener{
                shareprefrences.setStringPreference(context,"questionid",examlist[adapterPosition].id.toString())
                var intent=Intent(context!!, StartExamActivity::class.java)
                intent.putExtra("noofquestion",examlist[adapterPosition].questionCount.toString())
                intent.putExtra("durationa",examlist[adapterPosition].duration.toString())
                intent.putExtra("questionid",examlist[adapterPosition].id.toString())
                intent.putExtra("testnumber",examlist[adapterPosition].is_given.toString())
                context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExamAdapter.Classessholder {
        return Classessholder(
            LayoutInflater.from(context).inflate(R.layout.adpter_exam, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return examlist.size
    }

    override fun onBindViewHolder(holder: Classessholder, position: Int) {
        var count=examlist[position].questionCount
        Log.e("count",count.toString())

        holder.itemView.examname.text = examlist[position].title
        holder.itemView.questioncount.text = "Question Count  " + examlist[position].questionCount
    }


}