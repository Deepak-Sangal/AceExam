package com.acexams.aceexam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.QbanksubjectResponse
import kotlinx.android.synthetic.main.adpter_questionbank.view.*

class QuestionBankAdapter(var context: Context, var topiclikst:List<QbanksubjectResponse.Data.Chapter>) :
    RecyclerView.Adapter<QuestionBankAdapter.QuestionBankholder>() {
    inner class QuestionBankholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.open1.setOnClickListener {
                if (itemView.quetionbankrecycle.visibility == View.GONE) {
                    itemView.quetionbankrecycle.visibility = View.VISIBLE
                    Glide.with(context).load(R.drawable.uparrow).into(itemView.open1)
                } else {
                    itemView.quetionbankrecycle.visibility = View.GONE
                    Glide.with(context).load(R.drawable.downarrow).into(itemView.open1)
                }
            }
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuestionBankAdapter.QuestionBankholder {
        return QuestionBankholder(
            LayoutInflater.from(context).inflate(R.layout.adpter_questionbank, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return topiclikst.size
    }

    override fun onBindViewHolder(holder: QuestionBankholder, position: Int) {
        holder.itemView.nameeeee.text=topiclikst[position].level_name
        holder.itemView.topiccount.text=topiclikst[position].topic_count+" Topics"
        holder.itemView.quetionbankrecycle.layoutManager = LinearLayoutManager(context)
        holder.itemView.quetionbankrecycle.adapter = QuestionBankDeailsAdapter(context,topiclikst[position].topic,topiclikst[position].level_name)
    }
}