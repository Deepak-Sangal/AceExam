package com.acexams.aceexam.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.PerarlsActivity
import com.acexams.aceexam.activity.modal.AllperalResponse
import kotlinx.android.synthetic.main.adpter_pearlsdeatils.view.*

class PearlsDetalsAdapter(var context: Context, val list: List<AllperalResponse.Data.Pearl>) :
    RecyclerView.Adapter<PearlsDetalsAdapter.SliderHolder>() {
    inner class SliderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.showdata.setOnClickListener {
                val intent = Intent(context, PerarlsActivity::class.java)
                intent.putExtra("perldescrbion",list[adapterPosition].description)
                intent.putExtra("bookmark",list[adapterPosition].bookmark.toString())
                intent.putExtra("pearlid",list[adapterPosition].id.toString())
                intent.putExtra("pearltitle",list[adapterPosition].title.toString())
                context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderHolder {
        return SliderHolder(
            LayoutInflater.from(context).inflate(R.layout.adpter_pearlsdeatils, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SliderHolder, position: Int) {
        holder.itemView.title.text = list[position].title
    }

    override fun getItemCount(): Int {
        return list.size
    }

}