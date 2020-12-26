package com.acexams.aceexam.questiobank.adpater

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.questiobank.SubjectTopicActivity
import com.acexams.aceexam.questiobank.modal.SubjectListModal
import kotlinx.android.synthetic.main.subjectlist_layout.view.*

class SubjectAdpater(
    val context: Context,
    val subjectList: ArrayList<SubjectListModal.Data>,
    var value: String,
    var  subServicelistner: Sub_serviceListner
): RecyclerView.Adapter<SubjectAdpater.SubjectHolder>() {

    var subjectidList:ArrayList<String> = ArrayList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectHolder {
        val v=LayoutInflater.from(parent.context).inflate(
            R.layout.subjectlist_layout,
            parent,
            false
        )
        return SubjectHolder(v)
    }

    override fun getItemCount(): Int {
        return  subjectList.size
    }

    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {

        var subjectName=subjectList[position].title

        Log.e("value", value)

        if (value=="1"){
            holder.itemView.img_checked.visibility=View.VISIBLE
            holder.itemView.img_umchecked.visibility=View.GONE
            var id=subjectList[position].id
            for (i in 0 until subjectList.size){

                if (!subjectidList.contains(subjectList[position].id.toString())){
                    subjectidList.add(subjectList[position].id.toString())
                    Log.e("all_id", subjectidList.toString())
                    subServicelistner.onClickListner(subjectidList)
                }



            }
        }
        else{
            holder.itemView.img_checked.visibility=View.GONE
            holder.itemView.img_umchecked.visibility=View.VISIBLE


            holder.itemView.img_umchecked.setOnClickListener {

                holder.itemView.img_checked.visibility=View.VISIBLE
                holder.itemView.img_umchecked.visibility=View.GONE

                var subject_idd=subjectList[position].id.toString()
                if (!subjectidList.contains(subject_idd)){
                    subjectidList.add(subject_idd)
                    Log.e("subject_id", subjectidList.toString())
                }

                subServicelistner.onClickListner(subjectidList)


            }

            holder.itemView.img_checked.setOnClickListener {
                holder.itemView.img_umchecked.visibility=View.VISIBLE
                holder.itemView.img_checked.visibility=View.GONE

                var subject_idd=subjectList[position].id.toString()
                if (subjectidList.contains(subject_idd)){
                    subjectidList.remove(subject_idd)
                    Log.e("subject_id_remove", subjectidList.toString())
                }

                subServicelistner.onClickListner(subjectidList)

            }
        }


        holder.itemView.txt_subject_name.text=subjectList[position].title






          holder.itemView.txt_topic.setOnClickListener {
              var id=subjectList.get(position).id.toString()
              Log.e("id",id)
              var intent= Intent(context, SubjectTopicActivity::class.java)
              intent.putExtra("topic_id",id)
              context.startActivity(intent)
          }



    }



    inner class SubjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        init {


        }

    }


    interface Sub_serviceListner {
        fun onClickListner(
            subjectidList:ArrayList<String>
        )
    }
}