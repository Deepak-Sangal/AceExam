package com.acexams.aceexam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.adpater.StateAdpater
import com.acexams.aceexam.activity.modal.StateModal
import com.acexams.aceexam.activity.modal.StateResponse
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_state_selection.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class StateSelectionActivity : AppCompatActivity() {

    lateinit var stateList: ArrayList<StateModal>

    //    lateinit var stateAdpater:StateAdpater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_selection)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        init()
        wrongDtata()

//        stateList.add(StateModal("Andhra Pradesh"))
//        stateList.add(StateModal("Arunachal Pradesh"))
//        stateList.add(StateModal("Assam"))
//        stateList.add(StateModal("Bihar"))
//        stateList.add(StateModal("Chhattisgarh"))
//        stateList.add(StateModal("Goa"))
//        stateList.add(StateModal("Gujarat"))
//        stateList.add(StateModal("Haryana"))
//        stateList.add(StateModal("Himachal Pradesh"))
//        stateList.add(StateModal("Jharkhand"))
//        stateList.add(StateModal("Karnataka"))
//        stateList.add(StateModal("Kerala"))
//        stateList.add(StateModal("Madhya Pradesh"))
//        stateList.add(StateModal("Maharashtra"))
//        stateList.add(StateModal("Manipur"))
//        stateList.add(StateModal("Meghalaya"))
//        stateList.add(StateModal("Mizoram"))
//        stateList.add(StateModal("Nagaland"))
//        stateList.add(StateModal("Odisha"))


        recy_state.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        recy_state.adapter=stateAdpater
    }

    fun wrongDtata() {
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.states()
        call.enqueue(object : Callback<StateResponse> {
            override fun onResponse(call: Call<StateResponse>, response: Response<StateResponse>) {
                if (response.code() == 200) {
                    try {
                        recy_state.adapter = StateAdpater(
                            this@StateSelectionActivity,
                            response!!.body()!!.data.sortedByDescending { it.state_name?.toString() }
                                .reversed()
                        )
                    } catch (e: Exception) {
                        Log.e("exception", e.toString())
                    }
                } else {
                    Toast.makeText(
                        this@StateSelectionActivity,
                        "Something Went Wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }

            override fun onFailure(call: Call<StateResponse>, t: Throwable) {
                Log.e("data", t.toString())

            }

        })
    }

    fun init() {
        backbutton_state.setOnClickListener {
            onBackPressed()
        }
    }
}