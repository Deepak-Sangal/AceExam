package com.acexams.aceexam.exam

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.TestexamResponse
import com.acexams.aceexam.adapter.ExamAdapter
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.fragment_all_test.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllTestFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        all()
        recy_all.layoutManager=LinearLayoutManager(context)
    }


    fun all() {
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.testexam(
            "Bearer" + shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString(),
            " ",
            shareprefrences.getStringPreference(activity!!, "USER_ID").toString(),
        )
        call.enqueue(object : Callback<TestexamResponse> {
            override fun onResponse(call: Call<TestexamResponse>, response: Response<TestexamResponse>) {

                try {
                    if(response.code()==200){
                        try {
                            var list_data= response.body()!!.data

                            if (response.body()!!.status==200){
                                if (response.body()!!.data!=null || response.body()!!.data.size>0)
                                {

                                    for (i in 0 until response.body()!!.data.size){

                                        if (response.body()!!.data[i].questionCount!=0){
                                            recy_all.adapter= ExamAdapter(activity!!,response.body()!!.data)
                                        }
                                    }
                                }else{
                                    Toast.makeText(context,"No Data Found",Toast.LENGTH_SHORT).show()
                                }
                            }

                        }
                        catch (e: Exception){
                            Log.e("exception",e.toString())
                        }
                    }
                }catch (e:java.lang.Exception){

                }



            }

            override fun onFailure(call: Call<TestexamResponse>, t: Throwable) {

                Log.e("data",t.toString())

            }

        })
    }
}