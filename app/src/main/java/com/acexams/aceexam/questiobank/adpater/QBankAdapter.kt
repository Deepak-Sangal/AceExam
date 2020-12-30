package com.acexams.aceexam.questiobank.adpater

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.QuestionBankActivity
import com.acexams.aceexam.activity.modal.QbanksubjectResponse
import kotlinx.android.synthetic.main.qbank_layout.view.*


class QBankAdapter(var context: Context, var questionbanklist: List<QbanksubjectResponse.Data>): RecyclerView.Adapter<QBankAdapter.QuestionBankHolder>() {
    inner class QuestionBankHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.questionbakclick.setOnClickListener{
            var intent=  Intent(context, QuestionBankActivity::class.java)
            intent.putExtra("datalist", questionbanklist[adapterPosition].chapter)
            context.startActivity(intent)
        }
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionBankHolder {
        val v= LayoutInflater.from(parent.context).inflate(
            R.layout.qbank_layout,
            parent,
            false
        )
        return QuestionBankHolder(v)
    }

    override fun onBindViewHolder(holder: QuestionBankHolder, position: Int) {
       holder.itemView.qbankname.text=questionbanklist[position].title
       holder.itemView.textcomplete.text=questionbanklist[position].total_completed.toString() +"/" +questionbanklist[position].total_topics +" Completed"
    }

    override fun getItemCount(): Int {
       return questionbanklist.size
    }
}