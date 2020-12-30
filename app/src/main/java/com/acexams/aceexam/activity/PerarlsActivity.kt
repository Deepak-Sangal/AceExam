package com.acexams.aceexam.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.acexams.aceexam.R
import com.acexams.aceexam.retrofit.ApiInterface
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_perarls.*
import kotlinx.android.synthetic.main.activity_question_test.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerarlsActivity : AppCompatActivity() {
   var id :String=""
    var descrbtion:String=""
    var userId:String=""
    var boookmark:String=""
    var title:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perarls)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        descrbtion= intent.getStringExtra("perldescrbion").toString()
        id= intent.getStringExtra("pearlid").toString()
        boookmark= intent.getStringExtra("bookmark").toString()
        title= intent.getStringExtra("pearltitle").toString()
        userId=shareprefrences.getStringPreference(this, "USER_ID").toString()
        perltag.text="Pearl #" +id
        bhgbjdf.text=title
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dehfvhn.setText(Html.fromHtml(descrbtion, Html.FROM_HTML_MODE_COMPACT));
        } else {
            dehfvhn.setText(Html.fromHtml(descrbtion));
        }

        backbutton.setOnClickListener {
            onBackPressed()
        }

        settingbtn.setOnClickListener{
            if(boookmark=="0"){
                perlunbookkmark()
                boookmark=="1"
            }else{
                perlbookkmark()
                boookmark=="0"
            }
        }
    }


    fun perlbookkmark(){
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.perlbookmark(
            id,
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
                        settingbtn.setImageResource(R.drawable.unbookmark)
                        Toast.makeText(this@PerarlsActivity,message, Toast.LENGTH_SHORT).show()
                    }
                    else if (status.toInt()==401){
                        var message=json.getString("message")
                        Toast.makeText(this@PerarlsActivity,message, Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this@PerarlsActivity,"Something went wrong", Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }


    fun perlunbookkmark(){
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.perlbookmark(
            id,
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
                        settingbtn.setImageResource(R.drawable.bookmarkcommon)
                        Toast.makeText(this@PerarlsActivity,message, Toast.LENGTH_SHORT).show()
                    }
                    else if (status.toInt()==401){
                        var message=json.getString("message")
                        Toast.makeText(this@PerarlsActivity,message, Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this@PerarlsActivity,"Something went wrong", Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }
}