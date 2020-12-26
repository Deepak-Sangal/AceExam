package com.acexams.aceexam.questiobank

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.QbanksubjectResponse
import com.acexams.aceexam.questiobank.adpater.QBankAdapter
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.util.DialogUtils
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_subject_list.*
import kotlinx.android.synthetic.main.dialog_customtest.*
import kotlinx.android.synthetic.main.fragment_question_bank_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class QuestionBankFragement : Fragment() {
    lateinit var token:String
 lateinit var dialog:Dialog
 companion object{
      var questionNumber: String=""
 }
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
        return inflater.inflate(R.layout.fragment_question_bank_fragement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionbankrecycle.layoutManager=LinearLayoutManager(activity)
        token=shareprefrences.getStringPreference(activity!!, "ACCESS_TOKEN").toString()
//        questionbakclick.setOnClickListener{
//            startActivity(Intent(activity,QuestionBankActivity::class.java))
//        }
        customtest.setOnClickListener{
            verifyopendialog()
        }
        question()

    }


    fun verifyopendialog(){
        dialog = Dialog(activity!!)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.dialog_customtest)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.findViewById<TextView>(R.id.changenumber)!!.visibility=View.GONE
        dialog?.findViewById<Button>(R.id.btn_sumit)?.setOnClickListener{
            if( dialog?.findViewById<EditText>(R.id.otppassword)!!.text.toString().toInt()>20){
                Toast.makeText(activity,"You can not create more than 20", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if( dialog?.findViewById<EditText>(R.id.otppassword)!!.text.isEmpty()){
                Toast.makeText(activity,"Plz Enter Number of Question", Toast.LENGTH_SHORT).show()
            }else{

                startActivity(Intent(context,SubjectListActivity::class.java))
                questionNumber=dialog.otppassword.text.toString()
               /* shareprefrences.setStringPreference(activity!!,"custom","ture")
                shareprefrences.setStringPreference(activity!!,"numberofquesion", dialog?.findViewById<EditText>(R.id.otppassword)!!.text.toString())
                var intent=Intent(activity,TestActivity::class.java)
                startActivity(intent)*/
            }
        }
        dialog?.show()
    }


    fun question() {
        DialogUtils.showProgressLoadingBar(context)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.questionbankquestio(
            "Bearer" + token,
            ""
        )
        call.enqueue(object : Callback<QbanksubjectResponse> {
            override fun onResponse(call: Call<QbanksubjectResponse>, response: Response<QbanksubjectResponse>) {
                DialogUtils.dismissProgressLoadingBar()
                try {
                    if(response.code()==200){
                        try {
                            if(response.body()!!.status==200) {
                                try {
                                    if (response.body()!!.data!=null || response.body()!!.data.size>0){
                                        questionbankrecycle.adapter=QBankAdapter(activity!!,
                                            response.body()!!.data)
                                    }else{
                                        Toast.makeText(activity,"No Data Found", Toast.LENGTH_SHORT).show()
                                    }

                                } catch (e: Exception) {
                                    Log.e("exception", e.toString())
                                }
                            }
                            else{
                                Toast.makeText(activity,"Something Went Wrong", Toast.LENGTH_SHORT).show()
                            }
                        }catch (e:Exception){

                        }
                    }else{
                        Toast.makeText(activity,"Something Went Wrong", Toast.LENGTH_SHORT).show()
                    }
                }catch (e:Exception){

                }

            }

            override fun onFailure(call: Call<QbanksubjectResponse>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                Log.e("data",t.toString())
            }

        })
    }



}