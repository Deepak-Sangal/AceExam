package com.acexams.aceexam.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.TestActivity
import com.acexams.aceexam.activity.adpater.RankingAdpater
import com.acexams.aceexam.retrofit.ApiInterface
import com.example.paytm.RankingResponseModal
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_start_exam.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StartExamActivity : AppCompatActivity() {
    var token:String=""
    var noofcoint:String=""
    var questionidquestionid:String=""
    lateinit var userId:String
    lateinit var questioncount:String
    lateinit var duration:String
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_exam)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        toplisting.layoutManager=LinearLayoutManager(this)

        duration=intent.getStringExtra("durationa").toString()
        questioncount=intent.getStringExtra("testnumber").toString()
        noofcoint=intent.getStringExtra("noofquestion").toString()
        questionidquestionid=intent.getStringExtra("questionid").toString()
        userId=shareprefrences.getStringPreference(this, "USER_ID").toString()
        Log.e("userid",userId)
        backbutton.setOnClickListener {
            onBackPressed()
        }

        numberofquestion.text= "$noofcoint Mutiple Choice Question $duration Minutes"
        tv_startexam.setOnClickListener{
            Log.e("datadddd",questioncount)
            if(questioncount.equals("0")){
                shareprefrences.setStringPreference(this, "custom", "false")
                var intent = Intent(this, TestActivity::class.java)
                intent.putExtra("duration", duration)
                intent.putExtra("questionid", questionidquestionid)
                startActivity(intent)

            }else {
                Toast.makeText(this,"Already Given",Toast.LENGTH_SHORT).show()
            }
        }


        img_unbook.setOnClickListener {

            UnbookMark()
        }

        img_book.setOnClickListener {

            bookMark()
        }


    }


        fun data(){
            token=shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
            val apiService = ApiClient.getClient().create(ApiInterface::class.java)
            val call = apiService.topranikg("Bearer " + token,intent.getStringExtra("questionid").toString())
            call.enqueue(object : Callback<RankingResponseModal> {
                override fun onResponse(call: Call<RankingResponseModal>, response: Response<RankingResponseModal>) {
                    if(response.code()==200){
                        toplisting.adapter=RankingAdpater(this@StartExamActivity, response.body()!!.data.detial)
                    }else{
                      Toast.makeText(this@StartExamActivity,"Something went wrong",Toast.LENGTH_SHORT)
                    }
                }

                override fun onFailure(call: Call<RankingResponseModal>, t: Throwable) {
                    Log.e("data",t.toString())
                }

            })
        }


    fun bookMark(){

        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.bookMark(
            questionidquestionid,
            userId,
            "1"
           )
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.code()==200){
                    var obj= response.body()?.string()
                    var json = JSONObject(obj)
                    var status = json.getString("status")
                    if (status.toInt()==200){
                        var message=json.getString("message")
                        img_unbook.visibility=View.VISIBLE
                        img_book.visibility=View.GONE
                        Toast.makeText(this@StartExamActivity,message,Toast.LENGTH_SHORT).show()
                    }
                    else if (status.toInt()==401){
                        var message=json.getString("message")
                        Toast.makeText(this@StartExamActivity,message,Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this@StartExamActivity,"Something went wrong",Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }

    fun UnbookMark(){

        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.bookMark(
            questionidquestionid,
            userId,
            "0"
        )
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.code()==200){
                    var obj= response.body()?.string()
                    var json = JSONObject(obj)
                    var status = json.getString("status")
                    if (status.toInt()==200){
                        var message=json.getString("message")
                        img_unbook.visibility=View.GONE
                        img_book.visibility=View.VISIBLE
                        Toast.makeText(this@StartExamActivity,message,Toast.LENGTH_SHORT).show()
                    }

                }else{
                    img_book.visibility=View.VISIBLE
                    Toast.makeText(this@StartExamActivity,"Something went wrong",Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }

}