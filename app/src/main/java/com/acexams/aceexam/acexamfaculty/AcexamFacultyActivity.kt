package com.acexams.aceexam.acexamfaculty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.acexamfaculty.adapter.FacultyAdapter
import com.acexams.aceexam.activity.modal.FacalityResponse
import com.acexams.aceexam.retrofit.ApiInterface
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_acexam_faculty.*
import kotlinx.android.synthetic.main.fragment_home_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AcexamFacultyActivity : AppCompatActivity() {
    var token:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acexam_faculty)

        faculty_back.setOnClickListener {
            onBackPressed()
        }

        faculty_recycler.layoutManager = LinearLayoutManager(this)
        faclity()
//        var listone : Array<String> =  arrayOf("Teacher First","Teacher Second","Teacher Third","Teacher Fourth")


    }

    fun faclity() {
        token = shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.faclities(
            "Bearer " + token
        )
        call.enqueue(object : Callback<FacalityResponse> {
            override fun onResponse(
                call: Call<FacalityResponse>,
                response: Response<FacalityResponse>
            ) {
                if (response.code() == 200) {
                    if (response.body()!!.status==200){
                        faculty_recycler.adapter = FacultyAdapter(this@AcexamFacultyActivity,response!!.body()!!.data)
                    }
                } else   {
                    Toast.makeText(this@AcexamFacultyActivity, "Bookmark Not Found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<FacalityResponse>, t: Throwable) {
                Log.e("data", t.toString())
            }

        })
    }

}