package com.acexams.aceexam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.Model.GetProfileResponse
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.adpater.OerprogressAdapter
import com.acexams.aceexam.activity.modal.OverAllProcessResponse
import com.acexams.aceexam.retrofit.ApiInterface
import com.squareup.picasso.Picasso
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_over_all_progress.*
import kotlinx.android.synthetic.main.activity_user_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverAllProgressActivity : AppCompatActivity() {

    var list:ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over_all_progress)
        progreesrecyle.layoutManager=LinearLayoutManager(this)
        list.add("Anatomy")
        list.add("BioChemistry")
        list.add("Physiology")
        list.add("Microbiology")
        list.add("Pathology")
        list.add("ENT")
        alll()
    }


    private fun alll() {
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.overalll(
            shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString(),
            shareprefrences.getStringPreference(this, "USER_ID").toString()
        )
        call.enqueue(object : Callback<OverAllProcessResponse> {
            override fun onResponse(
                call: Call<OverAllProcessResponse>,
                response: Response<OverAllProcessResponse>
            ) {
                if (response.code() == 200) {
                    if (response.body()!!.data.size > 0) {
                    try {
                        error.visibility= View.GONE
                            progreesrecyle.adapter =
                                OerprogressAdapter(
                                    this@OverAllProgressActivity,
                                    response.body()!!.data
                                )
                        } catch (e: Exception) {
                            Log.e("error", e.toString())
                        }
                    }else{
                        error.visibility= View.GONE
                    }
                }
            }

            override fun onFailure(call: Call<OverAllProcessResponse>, t: Throwable) {
                Toast.makeText(this@OverAllProgressActivity, "invalid credentials", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }
}