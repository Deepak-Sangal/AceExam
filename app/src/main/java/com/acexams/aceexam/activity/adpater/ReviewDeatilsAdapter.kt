package com.acexams.aceexam.activity.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.questiobank.modal.ReviewDetailModal

class ReviewDeatilsAdapter(val context: Context, val stateList: List<ReviewDetailModal.Data>): RecyclerView.Adapter<ReviewDeatilsAdapter.StateHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateHolder {
        return StateHolder(LayoutInflater.from(context).inflate(R.layout.reviewdetails_layout, parent, false))
    }

    override fun onBindViewHolder(holder: StateHolder, position: Int) {
        holder.question.text=stateList[position].questiondetail.question
        holder.uranswer.text="Your Answer: " +stateList[position].answerdetail.options
        holder.expalin.text="Explaination: "+stateList[position].questiondetail.explaination
        holder.correct.text="Correct Answer: " +stateList[position].questiondetail.correctanswer.options
    }

    override fun getItemCount(): Int {
        return stateList.size
    }

   inner class StateHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       var question:TextView
       var uranswer:TextView
       var correct:TextView
       var expalin:TextView
       init {
           question=itemView.findViewById(R.id.question)
           uranswer=itemView.findViewById(R.id.uranswer)
           correct=itemView.findViewById(R.id.correct)
           expalin=itemView.findViewById(R.id.expalin)
       }
    }
}