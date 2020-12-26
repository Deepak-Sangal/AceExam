package com.acexams.aceexam.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.ExamsList
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.setting.SettingActivity
import com.acexams.aceexam.util.DialogUtils
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_course_selection.*
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.fragment_classes_fragement.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseSelectionActivity : AppCompatActivity() {
     var value:String="0"
    var couser:String=""
    var userId:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_selection)
        value=intent.getStringExtra("home").toString()
        userId=shareprefrences.getStringPreference(this, "USER_ID").toString()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        selectionback.setOnClickListener {
            onBackPressed()
        }

//        examlist()

        val ids = arrayOf("2", "5", "6", "9")

        cnf.setOnClickListener {

            if (value.equals("1")){

                val radioButtonID: Int = radGroup.checkedRadioButtonId
                val radioButton: View = radGroup.findViewById(radioButtonID)
                val idx: Int = radGroup.indexOfChild(radioButton)
                Log.e("valuedatanidhi",ids[idx].toString())
                var selected_value=ids[idx]
                updateCourse(selected_value)

            }else{
                val radioButtonID: Int = radGroup.checkedRadioButtonId
                val radioButton: View = radGroup.findViewById(radioButtonID)
                val idx: Int = radGroup.indexOfChild(radioButton)
                Log.e("valuedata",ids[idx].toString())
                shareprefrences.setStringPreference(this, "examid", ids[idx])
                startActivity(Intent(this, YearSelectionActivity::class.java))
            }

        }

    }

  /*  private fun Course(selected_value: String) {
        if (selected_value.equals("2")){
            couser="FMGE"
            Log.e("course",couser)
            proficeActivity(couser)
        }
        else if (selected_value.equals("5")){
            couser="NEET-PG"
            Log.e("course",couser)
            proficeActivity(couser)
        }
        else if (selected_value.equals("6")){
            couser="All India Entrance Exam"
            Log.e("course",couser)
            proficeActivity(couser)
        }

        else if (selected_value.equals("9")){
            couser="IIT Basic"
            Log.e("course",couser)
            proficeActivity(couser)
        }
    }

    fun proficeActivity(course:String){
        startActivity(Intent(this,SettingActivity::class.java).putExtra("course",course))
        finish()
    }*/



    private fun updateCourse(selected_value: String) {
        DialogUtils.showProgressLoadingBar(this)

        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.update_exam(
            userId,
            selected_value
        )
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                DialogUtils.dismissProgressLoadingBar()
                try {
                    if (response.code() == 200) {

                        var obj= response.body()!!.string()
                        var json=JSONObject(obj)
                        var status=json.getString("status")

                        if (status.toInt()==200){
                            var message=json.getString("message")
                            Toast.makeText(this@CourseSelectionActivity,message,Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@CourseSelectionActivity,SettingActivity::class.java))
                            finish()
                        }

                    }
                } catch (e: Exception) {
                    Log.e("error", e.toString())
                }


            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                Toast.makeText(this@CourseSelectionActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }

        })
//        btn_course.setOnClickListener {

//            shareprefrences.setStringPreference(this, "examid", "6")
//            startActivity(Intent(this, YearSelectionActivity::class.java))
//        }
//        neet.setOnClickListener {
//            shareprefrences.setStringPreference(this, "examid", "5")
//            startActivity(Intent(this, YearSelectionActivity::class.java))
//        }
//        fmge.setOnClickListener {
//            startActivity(Intent(this, YearSelectionActivity::class.java))
//            shareprefrences.setStringPreference(this, "examid", "2")
//        }
    }

    fun examlist() {
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.examslist()
        call.enqueue(object : Callback<ExamsList> {
            override fun onResponse(
                call: Call<ExamsList>,
                response: Response<ExamsList>
            ) {
                if (response.code() == 200) {
                    try {
                        response.body()?.data?.forEach {
                            val rb = RadioButton(this@CourseSelectionActivity);
                            rb.text = it.name;
                            //                            rb.setId(i + 100);
                            radGroup.addView(rb);
                        }
//                        rv.adapter = ExamListAdapter(response!!.body()!!.data)
                    } catch (e: Exception) {
                        Log.e("exception", e.toString())
                    }
                } else {
                    Toast.makeText(
                        this@CourseSelectionActivity,
                        "Something Went Wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ExamsList>, t: Throwable) {
                Log.e("data", t.toString())
            }

        })
    }


}