package com.acexams.aceexam.questiobank.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.questiobank.modal.QuestionNumberModal
import kotlinx.android.synthetic.main.question_number.view.*

class QuestionNumberAdapter(
    var context: Context,
    var number: MutableList<QuestionNumberModal>
)
    : RecyclerView.Adapter<QuestionNumberAdapter.NumberHolder>() {
    inner class NumberHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.question_number,parent,false)
        return NumberHolder(view)
    }

    override fun onBindViewHolder(holder: NumberHolder, position: Int) {
        holder.itemView.text_number.text = number[position].no.toString()
        if (number[position].status==1){
            holder.itemView.text_number.setBackgroundResource(R.drawable.corner30green)
            holder.itemView.text_number.setTextColor(context.resources.getColor(R.color.green))
        }else if(number[position].status==2){
            holder.itemView.text_number.setBackgroundResource(R.drawable.corner30pink)
            holder.itemView.text_number.setTextColor(context.resources.getColor(R.color.common))
        }
//     notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return number.size
    }
}