package com.acexams.aceexam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.politciannewapp.utils.MyProgressDialog
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.PlanResponse
import com.acexams.aceexam.adapter.ViewPlansAdapter
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_classes_acivity.*
import kotlinx.android.synthetic.main.activity_view_palns.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ViewPalnsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_palns)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        planreciver.layoutManager=LinearLayoutManager(this)
        plan()
        backvid.setOnClickListener {
            onBackPressed()
        }

    }

    fun plan() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.plan(
            "Bearer" + shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        )
        call.enqueue(object : Callback<PlanResponse> {
            override fun onResponse(call: Call<PlanResponse>, response: Response<PlanResponse>) {
                MyProgressDialog.dismissProgress()
                if(response.code()==200){
                    try {
                        planreciver.adapter=ViewPlansAdapter(this@ViewPalnsActivity!!,response.body()!!.data)
                    }
                    catch (e: Exception){
                        Log.e("exception",e.toString())
                    }
                }
            }
            override fun onFailure(call: Call<PlanResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data",t.toString())
            }
        })
    }
}