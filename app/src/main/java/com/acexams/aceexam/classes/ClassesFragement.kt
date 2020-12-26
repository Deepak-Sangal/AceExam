package com.acexams.aceexam.classes

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
import com.acexams.aceexam.activity.modal.CourseResponse
import com.acexams.aceexam.adapter.ClassesAdapter
import com.acexams.aceexam.util.DialogUtils
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.fragment_classes_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class ClassesFragement : Fragment() {

    lateinit var token: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        token = shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString()
        course()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classes_fragement, container, false)
    }

    /*companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ClassesFragement().apply {
                arguments = Bundle().apply {

                }
            }
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycle.layoutManager = LinearLayoutManager(activity)


    }


    fun course() {
        DialogUtils.showProgressLoadingBar(context)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getcourse("Bearer" + token)
        println("Anshu " + token)
        call.enqueue(object : Callback<CourseResponse> {
            override fun onResponse(
                call: Call<CourseResponse>,
                response: Response<CourseResponse>
            ) {
                DialogUtils.dismissProgressLoadingBar()

                try {
                    if (response.code() == 200) {
                        try {
                            if (response.body()!!.status==200 ){
                                if (response.body()!!.data!=null || response.body()!!.data!=null){
                                    recycle.adapter = ClassesAdapter(activity!!, response!!.body()!!.data)
                                }
                            }

                        } catch (e: Exception) {
                            Log.e("exception", e.toString())
                        }
                    } else {
                        Toast.makeText(activity, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                    }
                }catch (e:Exception){
                    Log.e("expection",e.toString())
                }

            }

            override fun onFailure(call: Call<CourseResponse>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                Log.e("data", t.toString())
            }
        })
    }
}