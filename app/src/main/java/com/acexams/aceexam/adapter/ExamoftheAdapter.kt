package com.acexams.aceexam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.AllperalResponse
import com.acexams.aceexam.activity.modal.examoftheday
import kotlinx.android.synthetic.main.adpter_examoftheday.view.*
import kotlinx.android.synthetic.main.adpter_pearls.view.*

class ExamoftheAdapter(var context: Context, val list: List<examoftheday.Data>) :
    RecyclerView.Adapter<ExamoftheAdapter.SliderHolder>() {

    inner class SliderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderHolder {
        return SliderHolder(
            LayoutInflater.from(context).inflate(R.layout.adpter_examoftheday, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SliderHolder, position: Int) {
        holder.itemView.tv_titiel.text=list[position].title
        holder.itemView.tv_time.text=list[position].duration.toString() + "minutes"
    }

    override fun getItemCount(): Int {
        return list.size
    }
}