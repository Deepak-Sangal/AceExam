package com.acexams.aceexam.faq.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.adapter_faqs.view.*

class FarAdpater(
    val context: Context,
    var  listone: Array<String>,
    var  listtwo: Array<String>
): RecyclerView.Adapter<FarAdpater.FaqHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.adapter_faqs,parent,false)
        return FaqHolder(view)
    }

    override fun onBindViewHolder(holder: FaqHolder, position: Int) {
        holder.itemView.faqs_question.text = listone.get(position)
        holder.itemView.faqs_answer.text = listtwo.get(position)
    }

    override fun getItemCount(): Int {
        return 4
    }

    class FaqHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.faqs_add.setOnClickListener {
                itemView.faqs_add.visibility = View.GONE
                itemView.faqs_minus.visibility = View.VISIBLE
                itemView.faqs_answer.visibility =View.VISIBLE
            }
            itemView.faqs_minus.setOnClickListener {
                itemView.faqs_add.visibility = View.VISIBLE
                itemView.faqs_minus.visibility = View.GONE
                itemView.faqs_answer.visibility =View.GONE

            }
        }
    }

}



