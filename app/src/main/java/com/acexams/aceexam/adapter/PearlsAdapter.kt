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
import kotlinx.android.synthetic.main.adpter_pearls.view.*

class PearlsAdapter(var context: Context, val list: List<AllperalResponse.Data>) :
    RecyclerView.Adapter<PearlsAdapter.SliderHolder>() {

    inner class SliderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.peralimage.setOnClickListener {
                if (itemView.peraldetails.visibility == View.GONE) {
                    itemView.peraldetails.visibility = View.VISIBLE
                    Glide.with(context).load(R.drawable.uparrow).into(itemView.peralimage)
                } else {
                    itemView.peraldetails.visibility = View.GONE
                    Glide.with(context).load(R.drawable.right).into(itemView.peralimage)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderHolder {
        return SliderHolder(
            LayoutInflater.from(context).inflate(R.layout.adpter_pearls, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SliderHolder, position: Int) {
        holder.itemView.title.text = list[position].title
        holder.itemView.peraldetails.layoutManager = LinearLayoutManager(context)
        holder.itemView.peraldetails.adapter = PearlsDetalsAdapter(context, list[position].pearls)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}