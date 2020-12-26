package com.acexams.aceexam.activity.adpater

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.CollageNameSelectionActivity
import com.acexams.aceexam.activity.modal.CollegeResponse
import kotlinx.android.synthetic.main.state_layout.view.*

class CollegelistAdapter(var context: Context,var collgelist:List<CollegeResponse.Data>):RecyclerView.Adapter<CollegelistAdapter.CollegelistHolder>() {
    class CollegelistHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollegelistHolder {
        return CollegelistHolder(LayoutInflater.from(context).inflate(R.layout.state_layout,parent,false))
    }

    override fun onBindViewHolder(holder: CollegelistHolder, position: Int) {
        holder.itemView.txt_state.text=collgelist[position].name
        holder.itemView.txt_state.setOnClickListener {
            shareprefrences.setStringPreference(context,"collegeid",collgelist[position].id.toString())
            var intent= Intent(context, CollageNameSelectionActivity::class.java)
            intent.putExtra("collegename",collgelist[position].name.toString())
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
       return  collgelist.size
    }
}