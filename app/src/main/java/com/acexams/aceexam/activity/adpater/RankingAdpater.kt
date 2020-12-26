package com.acexams.aceexam.activity.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R

import com.example.paytm.RankingResponseModal

class RankingAdpater(val context: Context, val stateList: List<RankingResponseModal.Data.Detial>): RecyclerView.Adapter<RankingAdpater.StateHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateHolder {
        return StateHolder(LayoutInflater.from(context).inflate(R.layout.ranking_layout, parent, false))
    }

    override fun onBindViewHolder(holder: StateHolder, position: Int) {



    }

    override fun getItemCount(): Int {
        return stateList.size
    }

   inner class StateHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       var username:TextView
       var tv_correct:TextView
       var wrong:TextView
       var skipped:TextView
       var lnr_state:LinearLayout
       init {
           username=itemView.findViewById(R.id.username)
           tv_correct=itemView.findViewById(R.id.tv_correct)
           wrong=itemView.findViewById(R.id.wrong)
           skipped=itemView.findViewById(R.id.skipped)
           lnr_state=itemView.findViewById(R.id.lnr_state)

       }
    }
}