package com.acexams.aceexam.exam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.OverAllProgressActivity
import com.acexams.aceexam.activity.modal.TestexamResponse
import com.acexams.aceexam.adapter.ExamAdapter
import com.acexams.aceexam.util.DialogUtils
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.fragment_grand_test.*
import retrofit2.Response



class GrandTestFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grand_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        examrecycel.layoutManager= LinearLayoutManager(activity!!)
        exam()
        texteee.setOnClickListener{
            startActivity(Intent(activity!!,OverAllProgressActivity::class.java))
        }

    }


        fun exam() {
            DialogUtils.showProgressLoadingBar(context)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.testexam(
            "Bearer" + shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString(),
            "200",
            shareprefrences.getStringPreference(activity!!, "USER_ID").toString()
        )
        call.enqueue(object : Callback<TestexamResponse> {
            override fun onResponse(call: Call<TestexamResponse>, response: Response<TestexamResponse>) {
               DialogUtils.dismissProgressLoadingBar()
                try {
                    if(response.code()==200){
                        try {
                            if (response.body()!!.status==200){
                                if (response.body()!!.data!=null || response.body()!!.data.size>0){
                                    examrecycel.adapter= ExamAdapter(activity!!,response.body()!!.data)
                                }else{
                                    Toast.makeText(context,"No Data Found",Toast.LENGTH_SHORT).show()
                                }

                            }

                        }
                        catch (e: Exception){
                            Log.e("exception",e.toString())
                        }
                    }
                }catch (e:Exception){

                }



            }

            override fun onFailure(call: Call<TestexamResponse>, t: Throwable) {
               DialogUtils.dismissProgressLoadingBar()
                Log.e("data",t.toString())

            }

        })
    }


}