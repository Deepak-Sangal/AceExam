package com.acexams.aceexam.activity.adpater

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.OverAllProcessResponse
import kotlinx.android.synthetic.main.overprogress_adapter.view.*
import kotlinx.android.synthetic.main.state_layout.view.*

class OerprogressAdapter(var context: Context,var list:List<OverAllProcessResponse.Data>):RecyclerView.Adapter<OerprogressAdapter.CollegelistHolder>() {
    class CollegelistHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollegelistHolder {
        return CollegelistHolder(LayoutInflater.from(context).inflate(R.layout.overprogress_adapter,parent,false))
    }

    override fun onBindViewHolder(holder: CollegelistHolder, position: Int) {
        holder.itemView.subjectnamef.text=list[position].subject_name
        holder.itemView.progresssss.progress=list[position].percent
    }

    override fun getItemCount(): Int {
       return  list.size
    }
}