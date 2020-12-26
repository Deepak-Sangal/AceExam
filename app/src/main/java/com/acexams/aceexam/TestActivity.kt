package com.acexams.aceexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.app.politciannewapp.utils.MyProgressDialog
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.activity.ReviewActivity
import com.acexams.aceexam.activity.modal.QuestionModals
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_start_exam.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.activity_test.img_book
import kotlinx.android.synthetic.main.activity_test.img_unbook
import kotlinx.android.synthetic.main.activity_view_palns.*
import kotlinx.android.synthetic.main.fragment_question_bank_fragement.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.concurrent.TimeUnit

class TestActivity : AppCompatActivity() {

    var id: String = ""
    var testid: String = ""
    var numberofquestion: String = ""
    var questionlist: ArrayList<QuestionModals.Data.Questionlist> = ArrayList()
    var questionArrayList: ArrayList<String> = ArrayList()
    var answerArrayList: ArrayList<String> = ArrayList()
    var hashMap: HashMap<String, String> = HashMap()
    var questiondata: String = ""
    var answerone: String = ""
    var answertwo: String = ""
    var answerthree: String = ""
    var questionsetid:String=""
    var answerfinal: String = ""
    var answerfour: String = ""
    var bookmark:Int=0
   var userId:String=""
    var questionid_default: String = ""

    var i: Int = 0
    var j: Int = 0

     var duration:Long=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        userId=shareprefrences.getStringPreference(this, "USER_ID").toString()
        if(intent.extras!=null) {
            duration = intent.getStringExtra("duration")!!.toLong()
        }
        Log.e("timernidh",duration.toString())
        if (shareprefrences.getStringPreference(this, "custom") == "ture") {
            numberofquestion = shareprefrences.getStringPreference(this, "numberofquesion")!!
            test()
        } else {
            id = shareprefrences.getStringPreference(this, "questionid")!!
            plan()
        }




        img_unbook.setOnClickListener {
            UnbookMark()
        }

        img_book.setOnClickListener {
            bookMark()
        }



        count_float_incr.setOnClickListener {
            System.out.println("questionlist${questionlist.size}")
            print("questlin list size${questionlist.size}")
            Log.e("value of ", i.toString())

            if (i < questionlist.size - 1) {
                i = i + 1
                bookmark= questionlist[i].questionset[0].bookmark
                if(bookmark==0){
                    img_unbook.visibility=View.GONE
                    img_book.visibility=View.VISIBLE
                }else{
                    img_unbook.visibility=View.VISIBLE
                    img_book.visibility=View.GONE
                }
                questionsetid= questionlist[0].questionset[0].id.toString()
                questiondata = questionlist[i].questionset[0].question
                answerone = questionlist[i].questionset[0].answers[0].options
                answertwo = questionlist[i].questionset[0].answers[1].options
                answerthree = questionlist[i].questionset[0].answers[2].options
                answerfour = questionlist[i].questionset[0].answers[3].options
                txt_question.setText( (i+1).toString() + ") " + questiondata)
                txt_ans_one.setText(answerone)
                txt_answaer_two.setText(answertwo)
                txt_answer_three.setText(answerthree)
                txt_answer_four.setText(answerfour)
            } else {
                Log.e("nixa", "xnxn")
                count_float_incr.visibility = View.GONE
            }

            firsttext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
            secondtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
            thirdtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
            fourthtext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
        }

       /* float_count_dcr.setOnClickListener {
            count_float_incr.visibility = View.VISIBLE

            if (i != 0 && i <= questionlist.size) {

                i = i - 1

                Log.e("desc value of i", i.toString())
                questiondata = questionlist[i].questionset[0].question
                answerone = questionlist[i].questionset[0].answers[0].options
                answertwo = questionlist[i].questionset[0].answers[1].options
                answerthree = questionlist[i].questionset[0].answers[2].options
                answerfour = questionlist[i].questionset[0].answers[3].options
                txt_question.setText(questiondata)
                txt_ans_one.setText(answerone)
                txt_answaer_two.setText(answertwo)
                txt_answer_three.setText(answerthree)
                txt_answer_four.setText(answerfour)
            } else {
                float_count_dcr.visibility = View.GONE
                count_float_incr.visibility = View.VISIBLE
                print("end of question")
            }
            txt_ans_one.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
            txt_answaer_two.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
            txt_answer_three.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
            txt_answer_four.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );

        }*/

        txt_ans_one.setOnClickListener {

            questiondata = questionlist[i].questionset[0].id.toString()
            answerfinal = questionlist[i].questionset[0].answers[0].id.toString()

            Log.e("ques 1", questiondata)
            Log.e("aswr 1", answerone)

            firsttext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.blue_border
                )
            )
            secondtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            thirdtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            fourthtext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )


            hashMap.put(questiondata, answerfinal)
            Log.e("datass", hashMap.toString())
        }

        txt_answaer_two.setOnClickListener {
            questiondata = questionlist[i].questionset[0].id.toString()
            answerfinal = questionlist[i].questionset[0].answers[1].id.toString()

            Log.e("ques 1", questiondata)
            Log.e("aswr 1", answerone)
            firsttext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            secondtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.blue_border
                )
            )
            thirdtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            fourthtext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )



            hashMap.put(questiondata, answerfinal)
            Log.e("datass", hashMap.toString())


        }

        txt_answer_three.setOnClickListener {
            questiondata = questionlist[i].questionset[0].id.toString()
            answerfinal = questionlist[i].questionset[0].answers[2].id.toString()
            firsttext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            secondtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            thirdtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.blue_border
                )
            )
            fourthtext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )




            hashMap.put(questiondata, answerfinal)
            Log.e("datass", hashMap.toString())


        }

        txt_answer_four.setOnClickListener {
            questiondata = questionlist[i].questionset[0].id.toString()
            answerfinal = questionlist[i].questionset[0].answers[3].id.toString()

            firsttext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
            secondtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
            thirdtest.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            );
            fourthtext.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.blue_border
                )
            );





            hashMap.put(questiondata, answerfinal)
            Log.e("datass", hashMap.toString())


        }

        img_go_back.setOnClickListener {
            onBackPressed()
        }


//         for (i in 0 until hashMap.size){
//             var value=hashMap.get(i)
//         }


        submit_test.setOnClickListener {
            for (key in hashMap.keys) {
                questionArrayList.add(key)
                Log.e("key", questionArrayList.toString())
            }
            for (key in hashMap.values) {
                answerArrayList.add(key)
                Log.e("valuee", answerArrayList.toString())
            }
            if (shareprefrences.getStringPreference(this, "custom") == "ture") {
                customsumit()
            } else {
                getSubmit()

            }

        }


        //=============Timer==========
        duration= TimeUnit.MINUTES.toMillis(duration)

        val timer = object: CountDownTimer(duration, 1000) {
            override fun onFinish() {
                txt_timer.setText("00:00");
                for (key in hashMap.keys) {
                    questionArrayList.add(key)
                    Log.e("key", questionArrayList.toString())
                }
                for (key in hashMap.values) {
                    answerArrayList.add(key)
                    Log.e("valuee", answerArrayList.toString())
                }

                getSubmit()
            }

            override fun onTick(millisUntilFinished: Long) {

                txt_timer.setText(
                    "" + String.format(
                        "%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes(
                                        millisUntilFinished
                                    )
                                )
                    )
                );
            }

        }
        timer.start()
    }

    fun test() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.custom(
            "Bearer" + shareprefrences.getStringPreference(this!!, "ACCESS_TOKEN").toString(),
            numberofquestion,
            shareprefrences.getStringPreference(this!!, "USER_ID").toString()
        )
        call.enqueue(object : Callback<QuestionModals> {
            override fun onResponse(
                call: Call<QuestionModals>,
                response: Response<QuestionModals>
            ) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        if (response.body()!!.status!!.toInt() == 200 && response.body()!!.data != null) {
                            var question = response.body()!!.data.questionlist
                            var title = response.body()?.data?.title
                            txt_question_title.setText(title)
                            if (question.size > 0) {
                                testid = response!!.body()!!.data.id.toString()
                                for (i in 0 until response.body()!!.data.questionlist.size) {
                                    questionlist.add(response.body()!!.data.questionlist[i])
                                }
                                bookmark=questionlist[0].questionset[0].bookmark
                                questionsetid= questionlist[0].questionset[0].id.toString()
                                if(bookmark==0){
                                    img_unbook.visibility=View.GONE
                                    img_book.visibility=View.VISIBLE
                                }else{
                                    img_unbook.visibility=View.VISIBLE
                                    img_book.visibility=View.GONE
                                }
                                questiondata = questionlist[0].questionset[0].question
                                answerone = questionlist[0].questionset[0].answers[0].options
                                answertwo = questionlist[0].questionset[0].answers[1].options
                                answerthree = questionlist[0].questionset[0].answers[2].options
                                answerfour = questionlist[0].questionset[0].answers[3].options
                                txt_question.setText("1) " +questiondata)
                                txt_ans_one.setText(answerone)
                                txt_answaer_two.setText(answertwo)
                                txt_answer_three.setText(answerthree)
                                txt_answer_four.setText(answerfour)
                                questionid_default = questionlist[0].questionset[0].id.toString()

                            }
                        }
                    } catch (e: Exception) {
                        Log.e("exception", e.toString())
                    }
                }
            }

            override fun onFailure(call: Call<QuestionModals>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data", t.toString())
            }

        })
    }


    fun plan() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.questiion(
            "Bearer" + shareprefrences.getStringPreference(this!!, "ACCESS_TOKEN").toString(),
            id,userId
        )
        call.enqueue(object : Callback<QuestionModals> {
            override fun onResponse(
                call: Call<QuestionModals>,
                response: Response<QuestionModals>
            ) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        if (response.body()!!.status!!.toInt() == 200 && response.body()!!.data != null) {
                            var question = response.body()!!.data.questionlist
                            var title = response.body()?.data?.title
                            txt_question_title.setText(title)
                            if (question.size > 0) {
                                for (i in 0 until response.body()!!.data.questionlist.size) {
                                    questionlist.add(response.body()!!.data.questionlist[i])
                                }
                                bookmark=questionlist[0].questionset[0].bookmark
                                if(bookmark==0){
                                    img_unbook.visibility=View.GONE
                                    img_book.visibility=View.VISIBLE
                                }else{
                                    img_unbook.visibility=View.VISIBLE
                                    img_book.visibility=View.GONE
                                }
                                questionsetid= questionlist[0].questionset[0].id.toString()
                                questiondata = questionlist[0].questionset[0].question
                                answerone = questionlist[0].questionset[0].answers[0].options
                                answertwo = questionlist[0].questionset[0].answers[1].options
                                answerthree = questionlist[0].questionset[0].answers[2].options
                                answerfour = questionlist[0].questionset[0].answers[3].options
                                txt_question.setText(questiondata)
                                txt_ans_one.setText(answerone)
                                txt_answaer_two.setText(answertwo)
                                txt_answer_three.setText(answerthree)
                                txt_answer_four.setText(answerfour)
                                questionid_default = questionlist[0].questionset[0].id.toString()

                            }
                        }
                    } catch (e: Exception) {
                        Log.e("exception", e.toString())
                    }
                }
            }

            override fun onFailure(call: Call<QuestionModals>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data", t.toString())
            }

        })
    }


    fun getSubmit() {

        Log.e("questiondatata", questiondata)


        val map: MutableMap<String, RequestBody> = HashMap()
        map["test_id"] = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), id)
        map["user_id"] = RequestBody.create(
            "multipart/form-data".toMediaTypeOrNull(),
            shareprefrences.getStringPreference(this, "USER_ID").toString()
        )
        Log.e("array", questionArrayList.toString())

        if (questionArrayList.size == 0) {
            map["question[$i]"] = RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(),
                questionid_default
            )
        } else {
            for (i in questionArrayList.indices) {
                map["question[$i]"] = RequestBody.create(
                    "multipart/form-data".toMediaTypeOrNull(),
                    questionArrayList[i].toString()
                )
            }
        }

        if (answerArrayList.size == 0) {
            map["answer[$i]"] = RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(),
                ""
            )
        } else {
            for (i in answerArrayList.indices) {
                map["answer[$i]"] = RequestBody.create(
                    "multipart/form-data".toMediaTypeOrNull(),
                    answerArrayList[i].toString()
                )
            }
        }


        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        var token =
            "Bearer" + shareprefrences.getStringPreference(this!!, "ACCESS_TOKEN").toString()
        val student_test = apiService.submit(token, map)
        student_test!!.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>, response: Response<ResponseBody>
            ) {
                if (response.code() == 200) {
                    var myobj = response.body()?.string()
                    Log.e("submit", myobj.toString())
                    var json = JSONObject(myobj)
                    var status = json.getString("status").toInt()
                    if (status == 200) {
                        var data = json.getJSONObject("data")
                        var percentage = data.getString("percentage")
                        var correct = data.getString("correct")
                        var incorect = data.getString("in_correct")
                        var skied = data.getString("skipped")
                        Toast.makeText(this@TestActivity, "success", Toast.LENGTH_SHORT).show()
                        var intent = Intent(this@TestActivity, ReviewActivity::class.java)
                         intent.putExtra("team_id", id)
                        intent.putExtra(
                            "user",
                            shareprefrences.getStringPreference(this@TestActivity, "USER_ID")
                                .toString()
                        )
                        intent.putExtra("correct", correct)
                        intent.putExtra("in_correct", incorect)
                        intent.putExtra("skipped", skied)
                        startActivity(intent)
                        finish()

                    } else if (status == 401) {
                        var message = json.getString("message")
                        Toast.makeText(this@TestActivity, message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(
                        this@TestActivity,
                        "Something Went Wrong",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                Log.e("error", t.toString())
            }


        })


    }

    fun customsumit() {

        Log.e("questiondatata", questiondata)


        val map: MutableMap<String, RequestBody> = HashMap()
        map["test_id"] = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), testid)
        map["user_id"] = RequestBody.create(
            "multipart/form-data".toMediaTypeOrNull(),
            shareprefrences.getStringPreference(this, "USER_ID").toString()
        )
        Log.e("array", questionArrayList.toString())

        if (questionArrayList.size == 0) {
            map["question[$i]"] = RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(),
                questionid_default
            )
        } else {
            for (i in questionArrayList.indices) {
                map["question[$i]"] = RequestBody.create(
                    "multipart/form-data".toMediaTypeOrNull(),
                    questionArrayList[i].toString()
                )
            }
        }

        if (answerArrayList.size == 0) {
            map["answer[$i]"] = RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(),
                ""
            )
        } else {
            for (i in answerArrayList.indices) {
                map["answer[$i]"] = RequestBody.create(
                    "multipart/form-data".toMediaTypeOrNull(),
                    answerArrayList[i].toString()
                )
            }
        }


        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        var token =
            "Bearer" + shareprefrences.getStringPreference(this!!, "ACCESS_TOKEN").toString()
        val student_test = apiService.customsumit(token, map)
        student_test!!.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>, response: Response<ResponseBody>
            ) {
                if (response.code() == 200) {
                    var myobj = response.body()?.string()
                    Log.e("submit", myobj.toString())
                    var json = JSONObject(myobj)
                    var status = json.getString("status").toInt()
                    if (status == 200) {
                        var data = json.getJSONObject("data")
                        var percentage = data.getString("percentage")
                        var correct = data.getString("correct")
                        var incorect = data.getString("in_correct")
                        var skied = data.getString("skipped")
                        Toast.makeText(this@TestActivity, "success", Toast.LENGTH_SHORT).show()
                        var intent = Intent(this@TestActivity, ReviewActivity::class.java)
                        intent.putExtra("data", percentage)
                        intent.putExtra("team_id", id)
                        intent.putExtra(
                            "user",
                            shareprefrences.getStringPreference(this@TestActivity, "USER_ID")
                                .toString()
                        )
                        intent.putExtra("correct", correct)
                        intent.putExtra("in_correct", incorect)
                        intent.putExtra("skipped", skied)
                        startActivity(intent)
                        finish()

                    } else if (status == 401) {
                        var message = json.getString("message")
                        Toast.makeText(this@TestActivity, message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(
                        this@TestActivity,
                        "Something Went Wrong",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                Log.e("error", t.toString())
            }


        })


    }

    fun bookMark(){

        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.bookMark(
            questionsetid,
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
                        Toast.makeText(this@TestActivity,message,Toast.LENGTH_SHORT).show()
                    }
                    else if (status.toInt()==401){
                        var message=json.getString("message")
                        Toast.makeText(this@TestActivity,message,Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this@TestActivity,"Something went wrong",Toast.LENGTH_SHORT)
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
            questionsetid,
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
                        Toast.makeText(this@TestActivity,message,Toast.LENGTH_SHORT).show()
                    }
                }else{
                    img_book.visibility=View.VISIBLE
                    Toast.makeText(this@TestActivity,"Something went wrong",Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }

    var currentFag: Fragment?=null;
    fun switchfragment(fragment: Fragment, isBack: Boolean) {
        currentFag=fragment

        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        if (isBack) {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
//            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment)
                .commitAllowingStateLoss()
//            drawer_layout.closeDrawer(GravityCompat.START)
        }
    }
}