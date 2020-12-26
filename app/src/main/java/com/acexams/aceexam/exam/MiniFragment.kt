package com.acexams.aceexam.exam

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.politciannewapp.utils.MyProgressDialog
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.TestexamResponse
import com.acexams.aceexam.adapter.ExamAdapter
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.fragment_mini.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class MiniFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mini, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        minirecycel.layoutManager= LinearLayoutManager(activity!!)
        exam()
    }

    fun exam() {
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.testexam(
            "Bearer" + shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString(),
            "50",
            shareprefrences.getStringPreference(activity!!, "USER_ID").toString()
        )
        call.enqueue(object : Callback<TestexamResponse> {
            override fun onResponse(call: Call<TestexamResponse>, response: Response<TestexamResponse>) {
                MyProgressDialog.dismissProgress()
                try {
                    if(response.code()==200){

                        if (response.body()!!.status==200){
                            try {
                                if (response.body()!!.data!=null || response.body()!!.data.size>0){
                                    minirecycel.adapter= ExamAdapter(activity!!,response.body()!!.data)
                                }

                            }
                            catch (e: Exception){
                                Log.e("exception",e.toString())
                            }
                        }

                    }
                }catch (e:java.lang.Exception){

                }

            }

            override fun onFailure(call: Call<TestexamResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data",t.toString())
            }

        })
    }
}