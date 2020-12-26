package com.acexams.aceexam.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.VideoListResponse
import com.acexams.aceexam.adapter.VideoListAdapter
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_classes_acivity.*
import kotlinx.android.synthetic.main.fragment_video_classes.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ClassesAcivity : AppCompatActivity(), View.OnClickListener {
    lateinit var token:String
    lateinit var id:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classes_acivity)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        backbutton.setOnClickListener(this)
        id=intent.getStringExtra("videoid").toString()
        describtion.text=intent.getStringExtra("titlename").toString()
        tv_des.text=intent.getStringExtra("chapterdes").toString()
        recyclevideo.layoutManager= LinearLayoutManager(this)
        data()

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.backbutton -> {
                onBackPressed()
            }
            R.id.videro -> {
                startActivity(Intent(this, ClassesVideoActivity::class.java))
            }
        }
    }


    fun data(){
        token=shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.video("Bearer " + token,id,shareprefrences.getStringPreference(this, "USER_ID").toString())
        call.enqueue(object : Callback<VideoListResponse> {
            override fun onResponse(call: Call<VideoListResponse>, response: Response<VideoListResponse>) {
                if(response.code()==200){
                    recyclevideo.adapter=VideoListAdapter(this@ClassesAcivity,response.body()!!.data)
//                    recycle.adapter= ClassesdropAdapter(this@ClassesAcivity,response!!.body()!!.data)

                }else if (response.code()==404){
                    Toast.makeText(this@ClassesAcivity,"No Video found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<VideoListResponse>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }
}