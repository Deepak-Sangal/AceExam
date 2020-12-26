package com.acexams.aceexam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.adpater.ReviewDeatilsAdapter
import com.acexams.aceexam.questiobank.modal.ReviewDetailModal
import com.acexams.aceexam.retrofit.ApiInterface
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_review_details.*
import kotlinx.android.synthetic.main.fragment_home_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewDetailsActivity : AppCompatActivity() {
    var token:String=""
    var test_id:String="0"
    var user_id:String="0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_details)
        test_id=intent.getStringExtra("test_id").toString()
        user_id=intent.getStringExtra("user").toString()
        reviewdaetisl.layoutManager=LinearLayoutManager(this)
        video()
        txt_back.setOnClickListener{
            onBackPressed()
        }
    }


    fun video(){
        token=shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.reviewdetails(
            "Bearer " + token,
            test_id,
            user_id
        )
        call.enqueue(object : Callback<ReviewDetailModal> {
            override fun onResponse(
                call: Call<ReviewDetailModal>,
                response: Response<ReviewDetailModal>
            ) {
                if(response.code()==200){
                    reviewdaetisl.adapter=ReviewDeatilsAdapter(this@ReviewDetailsActivity,response.body()!!.data)
                }
            }

            override fun onFailure(call: Call<ReviewDetailModal>, t: Throwable) {
                Log.e("data", t.toString())
            }

        })
    }
}