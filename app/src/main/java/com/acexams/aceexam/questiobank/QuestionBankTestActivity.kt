package com.acexams.aceexam.questiobank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.DashBoardActivity
import com.acexams.aceexam.activity.ReviewActivity
import com.acexams.aceexam.questiobank.SubjectListActivity.Companion.subjectidListData
import com.acexams.aceexam.questiobank.modal.QuestionBankTestListModal
import com.acexams.aceexam.retrofit.ApiInterface
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_question_bank_test.*
import kotlinx.android.synthetic.main.activity_subject_list.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class QuestionBankTestActivity : AppCompatActivity(){
    var id:String=""
    lateinit var token:String
    var testid:String=""
    var value="1"
    var subjectidTest:ArrayList<String> = ArrayList()
    lateinit var user_id:String
     var no_question:String=""
    var lang: String = ""
    var team_id: String = ""
    var questiondata: String = ""
    var answerone: String = ""
    var answertwo: String = ""
    var answerthree: String = ""
    var answerfour: String = ""
    var questionid_default:String=""
    var i: Int = 0;
    var j: Int = 0;
    lateinit var str: String;
    var answerfinal: String = ""
    lateinit var questionlist: ArrayList<QuestionBankTestListModal.Data.Questionlist>
    lateinit var questionArrayList:ArrayList<String>
    lateinit var answerArrayList:ArrayList<String>
    lateinit var hashMap: HashMap<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_bank_test)
       no_question = QuestionBankFragement.questionNumber
        Log.e("question_no",no_question)
        subjectidTest=subjectidListData
        Log.e("nidhi_id_data",subjectidTest.toString())

        token=shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        user_id=shareprefrences.getStringPreference(this!!, "USER_ID").toString()
        Log.e("user_id",user_id)
        Log.e("number",no_question)
        getTest()
        init()
    }

    fun init(){
        hashMap= hashMapOf()
        questionlist = arrayListOf()
        questionArrayList= arrayListOf()
        answerArrayList= arrayListOf()


        count_float_incr.setOnClickListener {
            float_count_dcr.visibility= View.VISIBLE
            print("questlin list size${questionlist.size}")
            Log.e("value of ", i.toString())

            if (i < questionlist.size - 1) {

                try {
                    i = i + 1
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
                }
                catch (e:Exception){

                }


            }
            else {
                Log.e("nixa", "xnxn")
                count_float_incr.visibility= View.GONE
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

        }

        float_count_dcr.setOnClickListener {
            count_float_incr.visibility= View.VISIBLE

            if (i != 0 && i <= questionlist.size) {

                try {
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
                }
                catch (e:Exception){

                }




            }
            else {
                float_count_dcr.visibility= View.GONE
                count_float_incr.visibility= View.VISIBLE
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

        }

        txt_ans_one.setOnClickListener {

            questiondata = questionlist[i].questionset[0].id.toString()
            answerfinal = questionlist[i].questionset[0].answers[0].id.toString()

            Log.e("ques 1", questiondata)
            Log.e("aswr 1", answerone)

            txt_ans_one.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.blue_border
                )
            )
            txt_answaer_two.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            txt_answer_three.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            txt_answer_four.setBackgroundDrawable(
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
            txt_ans_one.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            txt_answaer_two.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.blue_border
                )
            )
            txt_answer_three.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            txt_answer_four.setBackgroundDrawable(
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
            txt_ans_one.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            txt_answaer_two.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.black_border
                )
            )
            txt_answer_three.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.blue_border
                )
            )
            txt_answer_four.setBackgroundDrawable(
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
                    R.drawable.blue_border
                )
            );





            hashMap.put(questiondata, answerfinal)
            Log.e("datass", hashMap.toString())


        }

       /* clock= TimeUnit.MINUTES.toMillis(clock)
        Log.e("timee", clock.toString())

        val timer = object: CountDownTimer(clock, 1000) {
            override fun onFinish() {
                txt_timer.setText("Time's finished!");
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
                        "%d min, %d sec",
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
        timer.start()*/

        submit_test.setOnClickListener {
            for (key in hashMap.keys) {
                questionArrayList.add(key)
                Log.e("key", questionArrayList.toString())
            }
            for (key in hashMap.values) {
                answerArrayList.add(key)
                Log.e("valuee", answerArrayList.toString())
            }

            customsumit()
        }


    }


    fun getTest() {
        var finaltoken="Bearer" + token
        var  headers = HashMap<String, String>()
        headers.put("Authorization", finaltoken)
        val map: MutableMap<String, RequestBody> = HashMap()
        map["no_question"] = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), no_question)
        map["user_id"] = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), user_id)
        for (i in subjectidListData.indices){
            map["subject_id[$i]"] = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), subjectidListData[i].toString())
        }
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)

        val call = apiService.customTest(
            headers,
            map

        )
        call.enqueue(object : Callback<QuestionBankTestListModal> {
            override fun onResponse(call: Call<QuestionBankTestListModal>, response: Response<QuestionBankTestListModal>) {
                if (response.code() == 200) {

                    if (response.body()!!.status!!.toInt() == 200 && response.body()!!.data != null) {
                        var question = response.body()!!.data.questionlist
                        testid=response!!.body()!!.data.id.toString()
                        id= response.body()!!.data.id.toString()
//                        var title = response.body()?.data?.title
//                        txt_question_title.setText(title)

                        try {
                            if (question.size > 0) {
                                for (i in 0 until response.body()!!.data.questionlist.size) {
                                    questionlist.add(response.body()!!.data.questionlist.get(i))
                                    //var data=questionlist[0].questionset[0].question
                                }

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
                                Log.e("qyestion",questionid_default)


                            }
                        }catch (e:Exception){

                        }


                        /*if(questionlist.size>0){
                        for (i in 0 until questionlist.size){
                            val button = Button(this@QuestionActivity)
                            // setting layout_width and layout_height using layout parameters
                            button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                            button.text = "Button $i"
                            button.setOnClickListener { Toast.makeText(this@QuestionActivity, "Hello GEEK", Toast.LENGTH_LONG).show() }
                            lnr_lay.addView(button)
                        }
                    }*/


                    }
                } else {
                    Toast.makeText(
                        this@QuestionBankTestActivity,
                        "Something Went Wrong",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            }

            override fun onFailure(call: Call<QuestionBankTestListModal>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }

    fun customsumit() {

        Log.e("questiondatata",questiondata)


        val map: MutableMap<String, RequestBody> = HashMap()
        map["test_id"] = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), testid)
        map["user_id"] = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), shareprefrences.getStringPreference(this, "USER_ID").toString())
        Log.e("array",questionArrayList.toString())

        if (questionArrayList.size==0){
            map["question[$i]"] = RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(),
                questionid_default
            )
        }else{
            for (i in questionArrayList.indices){
                map["question[$i]"] = RequestBody.create(
                    "multipart/form-data".toMediaTypeOrNull(),
                    questionArrayList[i].toString()
                )
            }
        }

        if (answerArrayList.size==0){
            map["answer[$i]"] = RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(),
                ""
            )
        }
        else{
            for (i in answerArrayList.indices){
                map["answer[$i]"] = RequestBody.create(
                    "multipart/form-data".toMediaTypeOrNull(),
                    answerArrayList[i].toString()
                )
            }
        }


        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        var token="Bearer" + shareprefrences.getStringPreference(this!!, "ACCESS_TOKEN").toString()
        val student_test = apiService.customsumit(token,map)
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
                        Toast.makeText(this@QuestionBankTestActivity, "success", Toast.LENGTH_SHORT).show()
                        var intent = Intent(this@QuestionBankTestActivity, ReviewActivity::class.java)
                        intent.putExtra("data", percentage)
                        intent.putExtra("team_id", id)
                        intent.putExtra("user", shareprefrences.getStringPreference(this@QuestionBankTestActivity, "USER_ID").toString())
                        intent.putExtra("correct", correct)
                        intent.putExtra("in_correct", incorect)
                        intent.putExtra("skipped", skied)
                        startActivity(intent)

                    } else if (status == 401) {
                        var message = json.getString("message")
                        Toast.makeText(this@QuestionBankTestActivity, message, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(
                        this@QuestionBankTestActivity,
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


    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,DashBoardActivity::class.java))
    }
}