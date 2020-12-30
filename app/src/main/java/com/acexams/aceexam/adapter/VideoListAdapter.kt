package com.acexams.aceexam.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.ClassesVideoActivity
import com.acexams.aceexam.activity.modal.SubjectResponse
import com.acexams.aceexam.activity.modal.VideoListResponse
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.adapte_videolist.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shareprefrences


class VideoListAdapter(var context: Context, var videolist: List<VideoListResponse.Data>):RecyclerView.Adapter<VideoListAdapter.Classessholder>() {
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
                    "completed",
                    videolist[adapterPosition].completed.toString()
                )
                shareprefrences.setStringPreference(
                    context,
                    "videobookmark",
                    videolist[adapterPosition].status_videoBookmarked.toString()
                )
                shareprefrences.setStringPreference(
                    context,
                    "VIDEO_URL",
                    "http://www.acexam.com/web/public/uploads/courses/" + videolist[adapterPosition].name
                )
                shareprefrences.setStringPreference(
                    context,
                    "Rating",
                     videolist[adapterPosition].avgRating.toString()
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
                shareprefrences.setStringPreference(
                    context,
                    "videoid",
                    videolist[adapterPosition].id.toString()
                )
                var intent= Intent(context, ClassesVideoActivity::class.java)
                context.startActivity(intent)
            }

        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoListAdapter.Classessholder {
        return Classessholder(
            LayoutInflater.from(context).inflate(
                R.layout.adapte_videolist,
                parent,
                false
            )
        )
    }



    override fun getItemCount(): Int {
        return videolist.size
    }

    override fun onBindViewHolder(holder: Classessholder, position: Int) {
        holder.itemView.videotext.text=videolist[position].title
        if(videolist[position].paid==1){
            holder.itemView.videopaid.visibility=View.VISIBLE
        }else{
            holder.itemView.videopaid.visibility=View.GONE
        }
      Glide.with(context).asBitmap().load(("http://www.acexam.com/web/public/uploads/thumbnail/" + videolist[position].thumbnail)).into(holder.itemView.thumable)
    }

    fun data(id: String, recycle: RecyclerView){
        token=shareprefrences.getStringPreference(context, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.subject("Bearer " + token, id)
        call.enqueue(object : Callback<SubjectResponse> {
            override fun onResponse(
                call: Call<SubjectResponse>,
                response: Response<SubjectResponse>
            ) {
                if (response.code() == 200) {
                    recycle.adapter = ClassesdropAdapter(context, response!!.body()!!.data)

                } else {
                    Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SubjectResponse>, t: Throwable) {
                Log.e("data", t.toString())
            }

        })
    }

    @Throws(Throwable::class)
    fun retriveVideoFrameFromVideo(videoPath: String?): Bitmap? {
        var bitmap: Bitmap? = null
        var mediaMetadataRetriever: MediaMetadataRetriever? = null
        try {
            mediaMetadataRetriever = MediaMetadataRetriever()
            if (Build.VERSION.SDK_INT >= 14) mediaMetadataRetriever.setDataSource(
                videoPath,
                HashMap()
            ) else mediaMetadataRetriever.setDataSource(videoPath)
            //   mediaMetadataRetriever.setDataSource(videoPath);
            bitmap = mediaMetadataRetriever.frameAtTime
        } catch (e: Exception) {
            e.printStackTrace()
            throw Throwable("Exception in retriveVideoFrameFromVideo(String videoPath)" + e.message)
        } finally {
            mediaMetadataRetriever?.release()
        }
        return bitmap
    }
}