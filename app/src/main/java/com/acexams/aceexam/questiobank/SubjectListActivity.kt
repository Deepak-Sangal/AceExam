package com.acexams.aceexam.questiobank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.questiobank.adpater.SubjectAdpater
import com.acexams.aceexam.questiobank.modal.SubjectListModal
import com.acexams.aceexam.util.DialogUtils
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_subject_list.*
import kotlinx.android.synthetic.main.fragment_classes_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class SubjectListActivity : AppCompatActivity(),SubjectAdpater.Sub_serviceListner{
    lateinit var token:String
    var value="1"
    companion object{
        var subjectidListData:ArrayList<String> = ArrayList()
    }
    var subject_topic=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_list)
        subject_topic= SubjectTopicActivity.subjectid_topic_ListData
        Log.e("datanidihi",subject_topic.toString())


        token=shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        subjectList()

        recy_list.layoutManager=LinearLayoutManager(this)

        back_subject.setOnClickListener {
            onBackPressed()
        }

        lnr_all_subeject.setOnClickListener {
            img_all.setImageResource(R.drawable.ic_all);
            img_all_subject.setImageResource(R.drawable.ic_unchecked);
            value="1"
            subjectList()

        }

        lnr_choose_subject.setOnClickListener {
            img_all.setImageResource(R.drawable.ic_unchecked);
            img_all_subject.setImageResource(R.drawable.ic_all);
            value="2"
            subjectList()
        }

        btn_subjct_next.setOnClickListener {
            startActivity(Intent(this,NewCustomModule::class.java))
        }

    }

    fun subjectList() {
        DialogUtils.showProgressLoadingBar(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.subjectList(
            "Bearer" + token,
            "1"
        )
        call.enqueue(object : Callback<SubjectListModal> {
            override fun onResponse(call: Call<SubjectListModal>, response: Response<SubjectListModal>) {
                DialogUtils.dismissProgressLoadingBar()
                if(response.code()==200){
                    try {
                        recy_list.adapter= SubjectAdpater(this@SubjectListActivity,
                            response.body()!!.data,
                            value,
                            this@SubjectListActivity
                        )
                    }
                    catch (e: Exception){
                        Log.e("exception",e.toString())
                    }
                }else{
                    Toast.makeText(this@SubjectListActivity,"Something Went Wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SubjectListModal>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                Log.e("data",t.toString())
            }

        })
    }

    override fun onClickListner(subjectidList: ArrayList<String>) {
        subjectidListData=subjectidList
        Log.e("finaladata",subjectidListData.toString())

    }


}
