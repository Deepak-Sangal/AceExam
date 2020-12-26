package com.acexams.aceexam.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.CourseResponse
import com.acexams.aceexam.activity.modal.SubjectResponse
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.adpter_classes.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClassesAdapter(var context:Context,var courselist:List<CourseResponse.Data>):RecyclerView.Adapter<ClassesAdapter.Classessholder>() {
    lateinit var token:String
    inner class Classessholder (itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.opendrwable.setOnClickListener{
                if(itemView.classesrecycle.visibility==View.GONE){
                    data(courselist[adapterPosition].id.toString(), itemView.classesrecycle)
                    itemView.classesrecycle.visibility=View.VISIBLE
                    Glide.with(context).load(R.drawable.uparrow).into(itemView.open)
                }else{
                    itemView.classesrecycle.visibility=View.GONE
                    Glide.with(context).load(R.drawable.downarrow).into(itemView.open)
                }

            }
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClassesAdapter.Classessholder {
        return Classessholder(LayoutInflater.from(context).inflate(R.layout.adpter_classes, parent, false))
    }



    override fun getItemCount(): Int {
        return courselist.size
    }

    override fun onBindViewHolder(holder: Classessholder, position: Int) {
        holder.itemView.classesrecycle.layoutManager= LinearLayoutManager(context)
        holder.itemView.namecourse.text=courselist[position].title
        holder.itemView.count.text=courselist[position].chapterCount.toString() + " Classes"
        holder.itemView.bookmarkcount.text=courselist[position].bookmarkCount.toString()
    }

    fun data(id:String,recycle:RecyclerView){
        token=shareprefrences.getStringPreference(context, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.subject("Bearer " + token,id)
        call.enqueue(object : Callback<SubjectResponse> {
            override fun onResponse(call: Call<SubjectResponse>, response: Response<SubjectResponse>) {
                if(response.code()==200){
                        recycle.adapter= ClassesdropAdapter(context,response!!.body()!!.data)

                }else{
                    Toast.makeText(context,"Something Went Wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SubjectResponse>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }
}