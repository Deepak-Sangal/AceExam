package com.acexams.aceexam.home

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.Model.GetProfileResponse
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.ModResponse
import com.acexams.aceexam.activity.modal.ProgressTrackerResponse
import com.acexams.aceexam.activity.modal.examoftheday
import com.acexams.aceexam.adapter.ExamoftheAdapter
import com.acexams.aceexam.adapter.VideoodAdapter
import com.acexams.aceexam.contactus.ContactUsActivity
import com.acexams.aceexam.mcqbookmark.BookmarkActivity
import com.acexams.aceexam.progresstracker.ProgressTrackerActivity
import com.acexams.aceexam.setting.SettingActivity
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.search.SearchActivity
import com.acexams.aceexam.util.DialogUtils
import com.example.aceexam.activity.modal.VodResponse
import com.squareup.picasso.Picasso
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.fragment_home_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shareprefrences
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class HomeFragement : Fragment(), View.OnClickListener {

    lateinit var token: String
    lateinit var id: String
    lateinit var date: String
    lateinit var data: ModResponse
    var count:Int=0
    var userId:String=""

    var mod: ArrayList<ModResponse.Data.Answer> = ArrayList()

    var dialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fragement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        finddate()
        // token="Bearer"+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hY2V4YW0uY29tXC9hcGlcL3N0dWRlbnRcL3NpZ25pbiIsImlhdCI6MTYwNTE3Nzg1NCwiZXhwIjoxNjQxMTc3ODU0LCJuYmYiOjE2MDUxNzc4NTQsImp0aSI6InB4dEVVRTVFYk9LZW9PMDkiLCJzdWIiOjUzLCJwcnYiOiI4N2UwYWYxZWY5ZmQxNTgxMmZkZWM5NzE1M2ExNGUwYjA0NzU0NmFhIn0.SUhnD5hlrhHBXIob15JceMSXvUDy0o-bRXoLJGxaYms"
        classoftheday.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            true
        )
        examoftheday.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            true
        )
        userId=shareprefrences.getStringPreference(activity!!, "USER_ID").toString()
        id = shareprefrences.getStringPreference(context!!, "USER_ID").toString()
        token = shareprefrences.getStringPreference(context!!, "ACCESS_TOKEN").toString()

        Log.e("id", id.toString())
        Log.e("token", token.toString())
        mcq()
        process()
        settingbtn.setOnClickListener {
            startActivity(Intent(context, SettingActivity::class.java))

        }
        search_data.setOnClickListener{
            startActivity(Intent(activity!!,SearchActivity::class.java))
        }
        bookmark.setOnClickListener{
            startActivity(Intent(context, BookmarkActivity::class.java))
        }
        optiona.setOnClickListener(this)
        optionb.setOnClickListener(this)
        optionc.setOnClickListener(this)
        optiond.setOnClickListener(this)
        expalination.visibility=View.GONE
        firliner.setOnClickListener {
            if(count==0) {
                if (mod[0].is_correct == 1) {
                    firliner.background = (resources.getDrawable(R.drawable.greenfilled))
                } else {
                    firliner.background = (resources.getDrawable(R.drawable.cornerswithfill))
                }
                expalination.visibility=View.VISIBLE
                getrightanswer()
                count ++;
            }
        }

        linear2.setOnClickListener {
            if(count==0) {
                if (mod[1].is_correct == 1) {
                    linear2.background = (resources.getDrawable(R.drawable.greenfilled))
                } else {
                    linear2.background = (resources.getDrawable(R.drawable.cornerswithfill))
                }
                expalination.visibility=View.VISIBLE
                getrightanswer()
                count ++
            }

        }

        linear3.setOnClickListener {
            if(count==0) {
                if (mod[2].is_correct == 1) {
                    linear3.background = (resources.getDrawable(R.drawable.greenfilled))
                } else {
                    linear3.background = (resources.getDrawable(R.drawable.cornerswithfill))
                }
                expalination.visibility=View.VISIBLE
                getrightanswer()
                count ++
            }
        }
        linear4.setOnClickListener {
            if(count==0) {
                if (mod[3].is_correct == 1) {
                    linear4.background = (resources.getDrawable(R.drawable.greenfilled))
                } else {
                    linear4.background = (resources.getDrawable(R.drawable.cornerswithfill))
                }
                expalination.visibility=View.VISIBLE
                getrightanswer()
                count++
            }
        }
        video()
        examoftheday()
        img_user.setOnClickListener {
            startActivity(Intent(context, SettingActivity::class.java))
        }

        //=============Progress click============
        lnr_progress.setOnClickListener {
            startActivity(Intent(context,ProgressTrackerActivity::class.java))
        }

        rlvr_help.setOnClickListener {
            startActivity(Intent(context, ContactUsActivity::class.java))
        }
    }

    fun process() {
//        DialogUtils.showProgressLoadingBar(context)
//        pb.visibility = View.VISIBLE
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.progresstracker(
            "Bearer" + shareprefrences.getStringPreference(requireContext(), "ACCESS_TOKEN")
                .toString(),userId
        )
        call.enqueue(object : Callback<ProgressTrackerResponse> {
            override fun onResponse(call: Call<ProgressTrackerResponse>, response: Response<ProgressTrackerResponse>) {
                try {
                    if(response.code()==200){
                        weeklypercentage.text= response.body()!!.data.weeklyPercentage
                        montlypercentage.text= response.body()!!.data.monthlyPercentage
                    }
                }catch (e: java.lang.Exception){
                    Log.e("exception",e.toString())
                }

            }

            override fun onFailure(call: Call<ProgressTrackerResponse>, t: Throwable) {
                Log.e("data", t.toString())
            }
        })
    }



    fun getrightanswer(){
        for (i in 0..mod.size - 1){
            if(mod[i].is_correct==1){
                if(i==0){
                    firliner.background = (resources.getDrawable(R.drawable.greenfilled))
                }else if(i==1){
                    linear2.background = (resources.getDrawable(R.drawable.greenfilled))
                }else if(i==2){
                    linear3.background = (resources.getDrawable(R.drawable.greenfilled))
                }else if(i==3){
                    linear4.background = (resources.getDrawable(R.drawable.greenfilled))
                }
            }
        }
    }


    fun video() {
        token = shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.vod(
            "Bearer " + token
        )
        call.enqueue(object : Callback<VodResponse> {
            override fun onResponse(
                call: Call<VodResponse>,
                response: Response<VodResponse>
            ) {
                if (response.code() == 200) {
                    try {
                        classoftheday.adapter =
                            VideoodAdapter(activity!!, response.body()!!.data.videos)
                    }catch (e:java.lang.Exception){

                    }
                }
                else if (response.code() == 400) {
                    Toast.makeText(activity, "Bookmark Not Found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<VodResponse>, t: Throwable) {
                Log.e("data", t.toString())
            }

        })
    }

    fun examoftheday() {
        token = shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString()
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.examof(
            "Bearer " + token
        )
        call.enqueue(object : Callback<examoftheday> {
            override fun onResponse(
                call: Call<examoftheday>,
                response: Response<examoftheday>
            ) {
                if (response.code() == 200) {
                    try {
                        examoftheday.adapter =
                            ExamoftheAdapter(activity!!, response.body()!!.data)
                    }catch (e:java.lang.Exception){

                    }
                }
                else if (response.code() == 400) {
                    Toast.makeText(activity, "Bookmark Not Found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<examoftheday>, t: Throwable) {
                Log.e("data", t.toString())
            }

        })
    }


//    fun opendialog(){
//
//        dialog = Dialog(activity!!)
//        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog?.setContentView(R.layout.dialog_onelaststep)
//        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        dialog?.window!!.setLayout(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        )
//        dialog?.findViewById<TextView>(R.id.getFmcrotp)?.setOnClickListener{
//            dialog?.dismiss()
//            verifyopendialog()
//        }
//        dialog?.show()
//    }

    override fun onStart() {
        super.onStart()
        profile()
        Log.e("start", "start")
    }

    /* override fun onPause() {
         super.onPause()
         profile()
         Log.e("profile", "profile")
     }*/

    private fun profile() {
//        DialogUtils.showProgressLoadingBar(context)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getprofile(
            "Bearer" + token,
            id

        )
        call.enqueue(object : Callback<GetProfileResponse> {
            override fun onResponse(
                call: Call<GetProfileResponse>,
                response: Response<GetProfileResponse>
            ) {
                DialogUtils.dismissProgressLoadingBar()
                try {
                    if (response.code() == 200) {

                        if (response.body()!!.status.toInt()==200){
                            try {
                                txt_home.text = response.body()!!.data.name
                                txt_mobile.text=response.body()!!.data.year
                                txt_email.text=response.body()!!.data.email
                                var name = response.body()!!.data.name
                                var image = response.body()!!.data.image
                                if (image.equals("")){
                                    img_user.setBackgroundDrawable(ContextCompat.getDrawable(context!!, R.drawable.profile) );

                                }else{
                                    var const = "http://www.acexam.com/web/public/uploads/students/profile/"

                                    Picasso.get().load(const + image)
                                        .into(img_user)
                                }


                                txt_email.setText(response.body()!!.data.email)

                                if (response.body()!!.data.year!=null){
                                    txt_mobile.setText(response.body()!!.data.year)
                                }
                            }catch (e:Exception){

                            }
                        }


                    }
                } catch (e: Exception) {

                }


            }

            override fun onFailure(call: Call<GetProfileResponse>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    fun mcq() {
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.mqcoftheday("Bearer" + token)
        call.enqueue(object : Callback<ModResponse> {
            override fun onResponse(call: Call<ModResponse>, response: Response<ModResponse>) {

                try {
                    if (response.code() == 200) {
                        try {
                            if (response.body()!!.status==200){
                                if (response.body()!!.data[0] != null) {
                                    data = response!!.body()!!
                                    for (i in 0..response!!.body()!!.data.size - 1) {
                                        if (response!!.body()!!.data[i].date == date) {
                                            mcqoftheday.visibility=View.VISIBLE
                                            quickquestion.visibility=View.VISIBLE
                                            expalination.text=response!!.body()!!.data[i].explaination
                                            mod = response!!.body()!!.data[i].answers as ArrayList<ModResponse.Data.Answer>
                                            question.text = response!!.body()!!.data[i].question
                                            optiona.text =
                                                "A) " + response!!.body()!!.data[i].answers[0].options
                                            optionb.text =
                                                "B) " + response!!.body()!!.data[i].answers[1].options
                                            optionc.text =
                                                "C) " + response!!.body()!!.data[i].answers[2].options
                                            optiond.text =
                                                "D) " + response!!.body()!!.data[i].answers[3].options
                                        }
                                    }
                                }

                            }
                        }catch (e:java.lang.Exception){

                        }



                    }
                    else {
                        Toast.makeText(activity, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                    }
                }catch (e:java.lang.Exception){

                }


            }

            override fun onFailure(call: Call<ModResponse>, t: Throwable) {
                Log.e("data", t.toString())

            }

        })
    }

    override fun onClick(v: View?) {

    }


    fun finddate() {
        val cDate = Date()
        val fDate: String = SimpleDateFormat("yyyy-MM-dd").format(cDate)
        date = fDate;
        Log.e("data", fDate)
    }

}