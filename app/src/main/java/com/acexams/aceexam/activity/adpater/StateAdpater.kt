package com.acexams.aceexam.activity.adpater

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.CollageNameActivity
import com.acexams.aceexam.activity.modal.StateResponse

class StateAdpater(val context: Context, val stateList: List<StateResponse.Data>) :
    RecyclerView.Adapter<StateAdpater.StateHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateHolder {
        return StateHolder(
            LayoutInflater.from(context).inflate(R.layout.state_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StateHolder, position: Int) {


        holder.txt_state.text = stateList[position].state_name
        /*   if(stateList[position].color==1){
               holder.txt_state.background=context.resources.getDrawable(R.color.common)
           }*/
        holder.txt_state.setOnClickListener {
//            holder.lnr_state.background=context.resources.getDrawable(R.color.common)
            var intent = Intent(context, CollageNameActivity::class.java)
            intent.putExtra("stateid", stateList[position].state_id.toString())
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return stateList.size
    }

    inner class StateHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_state: TextView
        var lnr_state: LinearLayout

        init {
            txt_state = itemView.findViewById(R.id.txt_state)
            lnr_state = itemView.findViewById(R.id.lnr_state)

        }
    }
}