package com.acexams.aceexam.questiobank.adpater

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.questiobank.modal.SubjectTopicModal
import kotlinx.android.synthetic.main.subjectlist_layout.view.*

class SubjectTopicAdpater(var context: Context,
                          var topicList:ArrayList<SubjectTopicModal.Data>,
                          var value: String,
                          var subjecttopicListner: SubjectTopic_Listner
)
    : RecyclerView.Adapter<SubjectTopicAdpater.TopicHolder>() {
    var subjectidList:ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicHolder {

        val v= LayoutInflater.from(parent.context).inflate(
            R.layout.subjectlist_layout,
            parent,
            false
        )
        return TopicHolder(v)
    }

    override fun getItemCount(): Int {
        return  topicList.size
    }

    override fun onBindViewHolder(holder: TopicHolder, position: Int) {


        Log.e("value", value)

        if (value=="1"){
            holder.itemView.img_checked.visibility=View.VISIBLE
            holder.itemView.img_umchecked.visibility=View.GONE
            var id=topicList[position].id
            for (i in 0 until topicList.size){

                if (!subjectidList.contains(topicList[position].id.toString())){
                    subjectidList.add(topicList[position].id.toString())
                    Log.e("all_id", subjectidList.toString())
                   subjecttopicListner.onClickListner(subjectidList)
                }



            }
        }
        else{
            holder.itemView.img_checked.visibility=View.GONE
            holder.itemView.img_umchecked.visibility=View.VISIBLE


            holder.itemView.img_umchecked.setOnClickListener {

                holder.itemView.img_checked.visibility=View.VISIBLE
                holder.itemView.img_umchecked.visibility=View.GONE

                var subject_idd=topicList[position].id.toString()
                if (!subjectidList.contains(subject_idd)){
                    subjectidList.add(subject_idd)
                    Log.e("subject_id", subjectidList.toString())
                }

                subjecttopicListner.onClickListner(subjectidList)


            }

            holder.itemView.img_checked.setOnClickListener {
                holder.itemView.img_umchecked.visibility=View.VISIBLE
                holder.itemView.img_checked.visibility=View.GONE

                var subject_idd=topicList[position].id.toString()
                if (subjectidList.contains(subject_idd)){
                    subjectidList.remove(subject_idd)
                    Log.e("subject_id_remove", subjectidList.toString())
                }

              subjecttopicListner.onClickListner(subjectidList)

            }
        }


        holder.itemView.txt_subject_name.text=topicList[position].level_name
        holder.itemView.txt_topic.visibility=View.GONE
    }



    class TopicHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }



    interface SubjectTopic_Listner {
        fun onClickListner(
            subject_topic_id_list:ArrayList<String>
        )
    }
}