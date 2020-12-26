package com.acexams.aceexam.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.ClassesVideoActivity
import com.example.aceexam.activity.modal.VodResponse
import kotlinx.android.synthetic.main.adapte_videolist.view.thumable
import kotlinx.android.synthetic.main.adapte_videolist.view.videoitem
import kotlinx.android.synthetic.main.adapte_videooftheday.view.*
import shareprefrences


class VideoodAdapter(var context: Context, var videolist: List<VodResponse.Data.Video>):RecyclerView.Adapter<VideoodAdapter.Classessholder>() {
    lateinit var token:String
    inner class Classessholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.videoitem.setOnClickListener{
                shareprefrences.setStringPreference(
                    context,
                    "paid",
                    videolist[adapterPosition].paid.toString()
                )
                shareprefrences.setStringPreference(
                    context,
                    "VIDEO_URL",
                    "http://www.acexam.com/web/public/uploads/courses/" + videolist[adapterPosition].name
                )
                shareprefrences.setStringPreference(
                    context,
                    "VIDEO_ID",
                    videolist[adapterPosition].id.toString()
                )
                shareprefrences.setStringPreference(
                    context,
                    "descrition",
                    videolist[adapterPosition].title.toString()
                )
                shareprefrences.setStringPreference(
                    context,
                    "chaptertitile",
                    videolist[adapterPosition].description.toString()
                )
                var intent= Intent(context, ClassesVideoActivity::class.java)
                context.startActivity(intent)
            }

        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoodAdapter.Classessholder {
        return Classessholder(
            LayoutInflater.from(context).inflate(
                R.layout.adapte_videooftheday,
                parent,
                false
            )
        )
    }



    override fun getItemCount(): Int {
        return videolist.size
    }

    override fun onBindViewHolder(holder: Classessholder, position: Int) {
      Glide.with(context).asBitmap().load(("http://www.acexam.com/web/public/uploads/thumbnail/" + videolist[position].thumbnail)).into(holder.itemView.thumable)
        holder.itemView.videonameeeeee.text=videolist[position].description

    }


}