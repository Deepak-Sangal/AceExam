package com.acexams.aceexam.acexamfaculty.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.FacalityResponse
import com.acexams.aceexam.retrofit.Constants
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adpter_faculty.view.*

class FacultyAdapter(var context: Context,
                     var data1: List<FacalityResponse.Data>
):RecyclerView.Adapter<FacultyAdapter.FacultyHolder>()   {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyHolder {

        return FacultyHolder(LayoutInflater.from(context).inflate(R.layout.adpter_faculty,parent,false))
    }

    override fun onBindViewHolder(holder: FacultyHolder, position: Int) {
        holder.itemView.faculty_name.text = data1[position].name
        if(data1[position]!!.teacherdetail!=null) {
            holder.itemView.faculty_post.text = data1[position]!!.teacherdetail!!.qualification
            holder.itemView.faculty_department.text = data1[position]!!.teacherdetail!!.department
            holder.itemView.faculty_quotes.text = data1[position]!!.teacherdetail!!.description
            if(data1[position].teacherdetail.logo!=null) {
                Glide.with(context)
                    .load(Constants.imageBaseteacher + data1[position].teacherdetail.logo)
                    .into(holder.itemView.faculty_image);
            }
        }
    }

    override fun getItemCount(): Int {
        return data1.size
    }

    class FacultyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {

        }
    }
}