package com.acexams.aceexam.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.QuestionBankStartActivity
import com.acexams.aceexam.activity.modal.QbanksubjectResponse
import kotlinx.android.synthetic.main.adpter_questionbankdetals.view.*

class QuestionBankDeailsAdapter(var context:Context,var questionlist: ArrayList<QbanksubjectResponse.Data.Chapter.Topic>):RecyclerView.Adapter<QuestionBankDeailsAdapter.QuestionBankholder>() {
   inner class QuestionBankholder (itemView: View) : RecyclerView.ViewHolder(itemView){
        init {

         itemView.clickid.setOnClickListener{
             var intent= Intent(context, QuestionBankStartActivity::class.java)
             shareprefrences.setStringPreference(context,"topicid",questionlist[adapterPosition].id.toString())
             shareprefrences.setStringPreference(context,"questioncount",questionlist[adapterPosition].count.toString())
             context.startActivity(intent)
         }
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuestionBankDeailsAdapter.QuestionBankholder {
        return QuestionBankholder(LayoutInflater.from(context).inflate(R.layout.adpter_questionbankdetals, parent, false))
    }



    override fun getItemCount(): Int {
        return questionlist.size
    }

    override fun onBindViewHolder(holder: QuestionBankholder, position: Int) {
        holder.itemView.labaelname.text=questionlist[position].name
//        holder.itemView.quetionbankrecycle.layoutManager= LinearLayoutManager(context);
//        holder.itemView.quetionbankrecycle.adapter=ClassesdropAdapter(context)
    }
}