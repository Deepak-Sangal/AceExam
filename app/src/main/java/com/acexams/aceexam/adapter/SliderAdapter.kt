package com.acexams.aceexam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R

class SliderAdapter(var context: Context):RecyclerView.Adapter<SliderAdapter.SliderHolder>() {
    class SliderHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderHolder {
        return SliderHolder(
            LayoutInflater.from(context).inflate(R.layout.adpter_silder, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SliderHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 4
    }
}