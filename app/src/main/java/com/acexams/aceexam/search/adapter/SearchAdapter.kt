package com.acexams.aceexam.search.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.ClassesVideoActivity
import com.acexams.aceexam.activity.PerarlsActivity
import com.acexams.aceexam.activity.QuestionBankStartActivity
import com.acexams.aceexam.activity.modal.SearchResponse
import com.acexams.aceexam.activity.modal.VideoResponse
import com.acexams.aceexam.retrofit.ApiInterface
import com.app.politciannewapp.utils.MyProgressDialog
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.adpter_subject.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class SearchAdapter(var context: Context,var list: List<SearchResponse.Data>):RecyclerView.Adapter<SearchAdapter.SearchHolder>() {
    inner class SearchHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.clickonclick.setOnClickListener{
                if(list[adapterPosition].seachtype=="question Bank") {
                    var intent = Intent(context, QuestionBankStartActivity::class.java)
                    intent.putExtra("topicid", list[adapterPosition].id.toString())
                    shareprefrences.setStringPreference(
                        context,
                        "questioncount",
                        list[adapterPosition].question_count.toString()
                    )
                    context.startActivity(intent)
                }else if(list[adapterPosition].seachtype=="Video"){
                    plan(list[adapterPosition].id.toString())
                }else if(list[adapterPosition].seachtype=="Pearl"){
                    val intent = Intent(context, PerarlsActivity::class.java)
                    intent.putExtra("perldescrbion",list[adapterPosition].description)
                    intent.putExtra("pearltitle",list[adapterPosition].keyname)
                    intent.putExtra("bookmark","0")
                    intent.putExtra("pearlid",list[adapterPosition].id.toString())
                    context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        return SearchHolder(LayoutInflater.from(context).inflate(R.layout.adpter_subject, parent, false))
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.itemView.describtion.text=list[position].keyname
        holder.itemView.nameeeeeeeee.text=list[position].seachtype
    }

    override fun getItemCount(): Int {
        return list.size
    }


    fun plan(id:String) {
        MyProgressDialog.showProgress(context)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.videodetails(
            "Bearer" + shareprefrences.getStringPreference(context!!, "ACCESS_TOKEN").toString(),
            id,shareprefrences.getStringPreference(context!!, "USER_ID").toString()
        )
        call.enqueue(object : Callback<VideoResponse> {
            override fun onResponse(
                call: Call<VideoResponse>,
                response: Response<VideoResponse>
            ) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        shareprefrences.setStringPreference(context!!, "chaptertitile",response.body()!!.data[0].description)
                        shareprefrences.setStringPreference(context!!, "Rating",response.body()!!.data[0].avgRating)
                        shareprefrences.setStringPreference(context!!, "paid",response.body()!!.data[0].paid.toString())
                        shareprefrences.setStringPreference(context!!, "videoid",id)
                        shareprefrences.setStringPreference(context!!, "completed",response!!.body()!!.data[0].completed.toString())
                        shareprefrences.setStringPreference(context!!, "descrition",response!!.body()!!.data[0].title.toString())
                        shareprefrences.setStringPreference(context!!, "VIDEO_URL","http://www.acexam.com/web/public/uploads/courses/" + response.body()!!.data[0].name)
                        var intentdata = Intent(context, ClassesVideoActivity::class.java)
                        intentdata.putExtra("chaptertitile",response.body()!!.data[0].title)
                        context.startActivity(intentdata)
                    } catch (e: Exception) {
                        Log.e("exception", e.toString())
                    }
                }
            }

            override fun onFailure(call: Call<VideoResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data", t.toString())
            }

        })
    }
}
