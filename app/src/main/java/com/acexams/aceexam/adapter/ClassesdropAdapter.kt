package com.acexams.aceexam.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.ClassesAcivity
import com.acexams.aceexam.activity.modal.SubjectResponse
import com.acexams.aceexam.adapter.ClassesdropAdapter.Classesdropholder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adpter_classesdrop.view.*

class ClassesdropAdapter(var context: Context,var subjectlist:List<SubjectResponse.Data>):RecyclerView.Adapter<Classesdropholder>() {
    inner class Classesdropholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.data.setOnClickListener{
                var intent= Intent(context,ClassesAcivity::class.java)
                intent.putExtra("videoid",subjectlist[adapterPosition].id.toString())
                intent.putExtra("titlename",subjectlist[adapterPosition].level_name)
                intent.putExtra("chapterdes",subjectlist[adapterPosition].level_description)
                context.startActivity(intent)
            }
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Classesdropholder {
        return Classesdropholder(LayoutInflater.from(context).inflate(R.layout.adpter_classesdrop, parent, false))
    }

    override fun onBindViewHolder(holder: Classesdropholder, position: Int) {
        holder.itemView.des.text=subjectlist[position].level_name
        holder.itemView.title.text=subjectlist[position].level_description
        if(subjectlist[position].image!=null) {
            Glide.with(context).asBitmap()
                .load(("http://www.acexam.com/web/public/uploads/course/" + subjectlist[position].image))
                .into(holder.itemView.image_profiler)
        }
    }

    override fun getItemCount(): Int {
       return subjectlist.size
    }
}