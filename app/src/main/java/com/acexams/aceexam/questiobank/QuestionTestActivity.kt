package com.acexams.aceexam.questiobank

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.DashBoardActivity
import com.acexams.aceexam.activity.QuestionbankreviewActivity
import com.acexams.aceexam.questiobank.adpater.QuestionNumberAdapter
import com.acexams.aceexam.questiobank.modal.QuestionNumberModal
import com.acexams.aceexam.questiobank.modal.QuestiontestResponse
import com.acexams.aceexam.retrofit.ApiInterface
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_question_test.*
import kotlinx.android.synthetic.main.activity_question_test.img_book
import kotlinx.android.synthetic.main.activity_question_test.txt_ans_one
import kotlinx.android.synthetic.main.activity_question_test.txt_answaer_two
import kotlinx.android.synthetic.main.activity_question_test.txt_answer_four
import kotlinx.android.synthetic.main.activity_question_test.txt_answer_three
import kotlinx.android.synthetic.main.activity_question_test.txt_question
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okhttp3.internal.notifyAll
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionTestActivity : AppCompatActivity(), View.OnClickListener {
    var token=""
    var question=""
    var answerone= ""
    var answertwo= ""
    var answerthree= ""
    var answerfour= ""
    var correctanswer:Int=0
    var wrongsnwer:Int=0
    var answerkey:Int=0
    var userId:String=""
    var i:Int =0
    var count:Int=0
    var totalNumber:Int=0
    lateinit var dialog:Dialog
    var id:String=""
    var number:MutableList<QuestionNumberModal> = ArrayList()
    var sendquestion:ArrayList<String> =ArrayList()
    var sendanswer:ArrayList<String> =ArrayList()
    var sendstatus:ArrayList<String> = ArrayList()
    var qbanklis:ArrayList<QuestiontestResponse.Data> = ArrayList()
    var answer:ArrayList<QuestiontestResponse.Data.Answer> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_test)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        id= shareprefrences.getStringPreference(this,"topicid")!!
        userId=shareprefrences.getStringPreference(this, "USER_ID").toString()

        number_recycler.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
        questionbank()
        init()

    }

    private fun init() {
        txt_ans_one.setOnClickListener(this)
        txt_answaer_two.setOnClickListener(this)
        txt_answer_three.setOnClickListener(this)
        txt_answer_four.setOnClickListener(this)
        button.setOnClickListener(this)
        bookmarkwith.setOnClickListener(this)
    }


    fun questionbank(){
        token=shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.Questionbank(
            "Bearer " + token,
            id,userId
        )
        call.enqueue(object : Callback<QuestiontestResponse> {
            override fun onResponse(
                call: Call<QuestiontestResponse>,
                response: Response<QuestiontestResponse>
            ) {
                if (response.code() == 200) {
                    if(response.body()!!.status==200) {
                        if(response!!.body()!!.data.size>0) {
                            totalNumber= response.body()!!.data.size
                            for(n in 1..totalNumber){
                                var list=QuestionNumberModal(n,0)
                                number.add(list)
                            }

                            number_recycler.adapter = QuestionNumberAdapter(
                                this@QuestionTestActivity,number
                            )
                            questionb.visibility = View.VISIBLE
                            qbanklis =
                                response.body()!!.data as ArrayList<QuestiontestResponse.Data>
                            answer =
                                response!!.body()!!.data[0].answers as ArrayList<QuestiontestResponse.Data.Answer>
                            question = qbanklis[0].question
                            answerone = qbanklis[0].answers[0].options
                            answertwo = qbanklis[0].answers[1].options
                            answerthree = qbanklis[0].answers[2].options
                            answerfour = qbanklis[0].answers[3].options
                            questioncount.text="1"
                            txt_question.text =question
                            txt_ans_one.text = answerone
                            txt_answaer_two.text = answertwo
                            txt_answer_three.text = answerthree
                            txt_answer_four.text = answerfour
                            if(qbanklis[0].bookmark==0){
                                bookmarkwith.setImageDrawable(resources.getDrawable(R.drawable.unbookmark))
                            }else{
                                bookmarkwith.setImageDrawable(resources.getDrawable(R.drawable.bookmarkcommon))
                            }
                        }
                    }
                }
            }

            override fun onFailure(call: Call<QuestiontestResponse>, t: Throwable) {
                Log.e("data", t.toString())
            }

        })
    }

    override fun onClick(v: View?) {
when(v!!.id){
    R.id.txt_ans_one->{
        ContextCompat.getDrawable(
            this,
            R.drawable.black_border
        )
        answerkey=0
        if(count==0) {
            if (answer[0].is_correct == 1) {
                firstkey.background = (resources.getDrawable(R.drawable.green))
            } else {
                firstkey.background = (resources.getDrawable(R.drawable.pink))
            }
            firstkey.setTextColor(resources.getColor(R.color.whitetext));
            getrightanswer()
            count ++;
        }
        setdata()
    }
    R.id.txt_answaer_two->{
        ContextCompat.getDrawable(
            this,
            R.drawable.black_border
        )
        answerkey=1
        if(count==0) {
            if (answer[1].is_correct == 1) {
                secondkey.background = (resources.getDrawable(R.drawable.green))
            } else {
                secondkey.background = (resources.getDrawable(R.drawable.pink))
            }
            secondkey.setTextColor(resources.getColor(R.color.whitetext));
            getrightanswer()
            count ++;
        }
        setdata()
    }
    R.id.txt_answer_three->{
        ContextCompat.getDrawable(
            this,
            R.drawable.black_border
        )
        answerkey=2
        if(count==0) {
            if (answer[2].is_correct == 1) {
                thirdkey.background = (resources.getDrawable(R.drawable.green))
            } else {
                thirdkey.background = (resources.getDrawable(R.drawable.pink))
            }
            thirdkey.setTextColor(resources.getColor(R.color.whitetext));
            getrightanswer()
            count ++;
        }
        setdata()
    }
    R.id.txt_answer_four->{
        ContextCompat.getDrawable(
            this,
            R.drawable.black_border
        )
        answerkey=3
        if(count==0) {
            if (answer[3].is_correct == 1) {
                fourkey.background = (resources.getDrawable(R.drawable.green))
            } else {
                fourkey.background = (resources.getDrawable(R.drawable.pink))
            }
            fourkey.setTextColor(resources.getColor(R.color.whitetext));
            getrightanswer()
            count ++;
        }
        setdata()
    }
    R.id.button->{
        nextbutoon()
    }
    R.id.bookmarkwith->{
        if (qbanklis[i].bookmark==0){
            bookMark()
            qbanklis[i].bookmark=1
        }else{
            UnbookMark()
            qbanklis[i].bookmark=0
        }
    }
}
    }



    fun nextbutoon(){
        count=0
        firstkey.setTextColor(resources.getColor(R.color.common));
        firstkey.background = (resources.getDrawable(R.drawable.corner30pink))
        secondkey.setTextColor(resources.getColor(R.color.common));
        secondkey.background = (resources.getDrawable(R.drawable.corner30pink))
        thirdkey.setTextColor(resources.getColor(R.color.common));
        thirdkey.background = (resources.getDrawable(R.drawable.corner30pink))
        fourkey.setTextColor(resources.getColor(R.color.common));
        fourkey.background = (resources.getDrawable(R.drawable.corner30pink))
        if(button.text=="Submit"){
           getSubmit()
        }else {
            if (i < qbanklis.size - 1) {
                i = i + 1
                bottomwar.visibility = View.GONE
                questionb.visibility = View.VISIBLE
                explanication.visibility = View.GONE
                answer = qbanklis[i].answers as ArrayList<QuestiontestResponse.Data.Answer>
                question = qbanklis[i].question
                answerone = qbanklis[i].answers[0].options
                answertwo = qbanklis[i].answers[1].options
                answerthree = qbanklis[i].answers[2].options
                answerfour = qbanklis[i].answers[3].options
                questioncount.text=(i+1).toString()
                txt_question.text =question
                txt_ans_one.text = answerone
                txt_answaer_two.text = answertwo
                txt_answer_three.text = answerthree
                txt_answer_four.text = answerfour
            }
        }
    }

    fun opendailog() {
        dialog = Dialog(this)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.dialog_result)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        for (i in 0..sendstatus.size-1) {
            if(sendstatus[i]=="0"){
                wrongsnwer=wrongsnwer+1
            }else{
                correctanswer=correctanswer+1
            }
        }
        dialog?.findViewById<TextView>(R.id.txt_crt_ans)?.text="Correct Answer :" + correctanswer.toString()
        dialog?.findViewById<TextView>(R.id.txt_incr_ansr)?.text="InCorrect Answer :" + wrongsnwer.toString()
        dialog?.findViewById<TextView>(R.id.tv_review).setOnClickListener{
            var intent=Intent(this,DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }
        dialog?.show()
    }

    
    fun setdata(){
        if(i==qbanklis.size-1){
            button.text="Submit"
        }
        sendquestion.add(qbanklis[i].id.toString())
        sendanswer.add(qbanklis[i].answers[answerkey].id.toString())




        explanication.visibility=View.VISIBLE
        bottomwar.visibility=View.VISIBLE
        if(qbanklis[i].answers[answerkey].is_correct==1){
            number[i].status = 1
            sendstatus.add("1")
        }else{
            number[i].status = 2
            sendstatus.add("0")
        }
        number_recycler.adapter = QuestionNumberAdapter(
            this@QuestionTestActivity,number
        )
        if(qbanklis[i].bookmark==1){
            bookmarkwith.setImageDrawable(resources.getDrawable(R.drawable.unbookmark))
        }else{
            bookmarkwith.setImageDrawable(resources.getDrawable(R.drawable.bookmarkcommon))
        }
        explanition.text=qbanklis[i].explaination
    }

    fun getrightanswer(){
        for (j in 0..answer.size - 1){
            if(answer[j].is_correct==1){
                if(j==0){
                    firstkey.setTextColor(resources.getColor(R.color.whitetext));
                    firstkey.background = (resources.getDrawable(R.drawable.green))
                }else if(j==1){
                    secondkey.setTextColor(resources.getColor(R.color.whitetext));
                    secondkey.background = (resources.getDrawable(R.drawable.green))
                }else if(j==2){
                    thirdkey.setTextColor(resources.getColor(R.color.whitetext));
                    thirdkey.background = (resources.getDrawable(R.drawable.green))
                }else if(j==3){
                    fourkey.setTextColor(resources.getColor(R.color.whitetext));
                    fourkey.background = (resources.getDrawable(R.drawable.green))
                }
            }
        }
    }


    fun bookMark(){
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.bookMark(
            qbanklis[i].id.toString(),
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
                        bookmarkwith.setImageResource(R.drawable.unbookmark)
                        Toast.makeText(this@QuestionTestActivity,message,Toast.LENGTH_SHORT).show()
                    }
                    else if (status.toInt()==401){
                        var message=json.getString("message")
                        Toast.makeText(this@QuestionTestActivity,message,Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this@QuestionTestActivity,"Something went wrong",Toast.LENGTH_SHORT)
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
            qbanklis[i].id.toString(),
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
                        bookmarkwith.setBackgroundResource(R.drawable.bookmarkcommon)
                        Toast.makeText(this@QuestionTestActivity,message,Toast.LENGTH_SHORT).show()
                    }
                }else{
                    img_book.visibility=View.VISIBLE
                    Toast.makeText(this@QuestionTestActivity,"Something went wrong",Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("data",t.toString())
            }

        })
    }




    fun getSubmit() {



        val map: MutableMap<String, RequestBody> = HashMap()
        map["topic_id"] = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), id)
        map["user_id"] = RequestBody.create(
            "multipart/form-data".toMediaTypeOrNull(),
            shareprefrences.getStringPreference(this, "USER_ID").toString()
        )





            for (i in sendquestion.indices) {
                map["question[$i]"] = RequestBody.create(
                    "multipart/form-data".toMediaTypeOrNull(),
                    sendquestion[i].toString()
                )
            }


        for (i in sendstatus.indices) {
            map["status[$i]"] = RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(),
                sendstatus[i].toString()
            )
        }
        for (i in sendstatus.indices) {
            map["status[$i]"] = RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(),
                sendstatus[i].toString()
            )
        }

        for (i in sendanswer.indices) {
            map["answer[$i]"] = RequestBody.create(
                "multipart/form-data".toMediaTypeOrNull(),
                sendanswer[i].toString()
            )
        }



        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        var token =
            "Bearer" + shareprefrences.getStringPreference(this!!, "ACCESS_TOKEN").toString()
        val student_test = apiService.questionbanksumit(token, map)
        student_test!!.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>, response: Response<ResponseBody>
            ) {
                if (response.code() == 200) {
                    for (i in 0..sendstatus.size-1) {
                        if(sendstatus[i]=="0"){
                            wrongsnwer=wrongsnwer+1
                        }else{
                            correctanswer=correctanswer+1
                        }
                    }
                   var intent= Intent(this@QuestionTestActivity,QuestionbankreviewActivity::class.java)
                    intent.putExtra("current",correctanswer.toString())
                    intent.putExtra("wrong",wrongsnwer.toString())
                    startActivity(intent)
                    finish()
//                    opendailog()
//                    var myobj = response.body()?.string()
//                    Log.e("submit", myobj.toString())
//                    var json = JSONObject(myobj)
//                    var status = json.getString("status").toInt()
//                    if (status == 200) {
//                        var data = json.getJSONObject("data")
//                        var percentage = data.getString("percentage")
//                        var correct = data.getString("correct")
//                        var incorect = data.getString("in_correct")
//                        var skied = data.getString("skipped")
//                        Toast.makeText(this@QuestionTestActivity, "success", Toast.LENGTH_SHORT).show()
//                        var intent = Intent(this@QuestionTestActivity, ReviewActivity::class.java)
//                        intent.putExtra("data", percentage)
//                        intent.putExtra("team_id", id)
//                        intent.putExtra(
//                            "user",
//                            shareprefrences.getStringPreference(this@QuestionTestActivity, "USER_ID")
//                                .toString()
//                        )
//                        intent.putExtra("correct", correct)
//                        intent.putExtra("in_correct", incorect)
//                        intent.putExtra("skipped", skied)
//                        startActivity(intent)
//
//                    } else if (status == 401) {
//                        var message = json.getString("message")
   //                    }
                } else {
                    Toast.makeText(
                        this@QuestionTestActivity,
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


}