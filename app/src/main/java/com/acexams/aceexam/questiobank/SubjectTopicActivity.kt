package com.acexams.aceexam.questiobank
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.questiobank.adpater.SubjectTopicAdpater
import com.acexams.aceexam.questiobank.modal.SubjectTopicModal
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.util.DialogUtils
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_subject_list.*
import kotlinx.android.synthetic.main.activity_subject_topic.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class SubjectTopicActivity : AppCompatActivity(),SubjectTopicAdpater.SubjectTopic_Listner {
    lateinit var token:String
    var value="1"
    lateinit var topic_id:String
    companion object{
        var subjectid_topic_ListData:ArrayList<String> = ArrayList()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_topic)
        topic_id=intent.getStringExtra("topic_id").toString()

        token=shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        subjectTopicList()

        recy_list_topic.layoutManager= LinearLayoutManager(this)

        back_subject_topic.setOnClickListener {
            onBackPressed()
        }

        lnr_all_subeject_topic.setOnClickListener {
            img_all_topic.setImageResource(R.drawable.ic_all);
            img_all_subject_topic.setImageResource(R.drawable.ic_unchecked);
            value="1"
            subjectTopicList()

        }

        lnr_choose_subject_topic.setOnClickListener {
            img_all_topic.setImageResource(R.drawable.ic_unchecked);
            img_all_subject_topic.setImageResource(R.drawable.ic_all);
            value="2"
            subjectTopicList()
        }


    }


    fun subjectTopicList() {
        DialogUtils.showProgressLoadingBar(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.subjectTopicList(
            "Bearer" + token,
            topic_id
        )
        call.enqueue(object : Callback<SubjectTopicModal> {
            override fun onResponse(call: Call<SubjectTopicModal>, response: Response<SubjectTopicModal>) {
                DialogUtils.dismissProgressLoadingBar()
                if(response.code()==200){
                    try {
                        recy_list_topic.adapter= SubjectTopicAdpater(this@SubjectTopicActivity,
                            response.body()!!.data,
                            value,
                            this@SubjectTopicActivity

                        )
                    }
                    catch (e: Exception){
                        Log.e("exception",e.toString())
                    }
                }else{
                    Toast.makeText(this@SubjectTopicActivity,"Something Went Wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SubjectTopicModal>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                Log.e("data",t.toString())
            }

        })
    }

    override fun onClickListner(subject_topic_id_list: ArrayList<String>) {
        subjectid_topic_ListData=subject_topic_id_list
        Log.e("stubject_topic", subjectid_topic_ListData.toString())

        txt_save.setOnClickListener {
            startActivity(Intent(this,SubjectListActivity::class.java).putExtra("subject_topic",subject_topic_id_list))

        }
    }
}