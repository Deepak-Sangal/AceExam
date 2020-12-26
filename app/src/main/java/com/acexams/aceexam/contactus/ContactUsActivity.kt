package com.acexams.aceexam.contactus

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.AllperalResponse
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.util.DialogUtils
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_contact_us.*
import kotlinx.android.synthetic.main.fragment_pearls_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class ContactUsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var userId:String=""
    var details : Array<String> = arrayOf(
        "others",
        "QBank modules",
        "Video",
        "Subscription & Refund",
        "General Question",
        "Acexam Notes",
        "Help & Support",
        "Test Series"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        contact_us_back.setOnClickListener {
            onBackPressed()
        }


        contact_us_spinner!!.onItemSelectedListener = this
        userId=shareprefrences.getStringPreference(this, "USER_ID").toString()
        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, details)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        contact_us_spinner!!.adapter = aa


//        contact_us_spinner.adapter = SpinnerAdapter(this,details)


       /* contact_us_send.setOnClickListener {
            if(contact_us_msg.text==null){
                contact_us_msg.error = "enter some message to send"
                contact_us_msg.requestFocus()
            }else{
                val intent= Intent()
                intent.action= Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,contact_us_msg.text)
                intent.type="text/html"
                startActivity(Intent.createChooser(intent,"Send via:"))
            }
        }*/
        contact_us_send.setOnClickListener{
            validatef()
        }

    }

    private fun validatef() {
        if(contact_us_msg.text.isEmpty()){
            Toast.makeText(this,"Plz Enter Message ",Toast.LENGTH_SHORT).show()
        }else{
            cpontect()
        }
    }

//     fun sendEmail() {
//        val TO = arrayOf("")
//        val CC = arrayOf("")
//        val emailIntent = Intent(Intent.ACTION_SEND)
//        emailIntent.data = Uri.parse("mailto:")
//        emailIntent.type = "text/plain"
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO)
//        emailIntent.putExtra(Intent.EXTRA_CC, CC)
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject")
//        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here")
//        try {
//            startActivity(Intent.createChooser(emailIntent, "Send mail..."))
//            finish()
//        } catch (ex: ActivityNotFoundException) {
//            Toast.makeText(
//                applicationContext,
//                "There is no email client installed.",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }


    fun cpontect() {
        DialogUtils.showProgressLoadingBar(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.contact(
            "Bearer" + shareprefrences.getStringPreference(this, "ACCESS_TOKEN")
                .toString(),userId,contact_us_msg.text.toString()
        )
        call.enqueue(object : Callback<AllperalResponse> {
            override fun onResponse(call: Call<AllperalResponse>, response: Response<AllperalResponse>) {
                DialogUtils.dismissProgressLoadingBar()
                try {
                    if (response.code() == 200) {
                        try {

                            Toast.makeText(this@ContactUsActivity, "Sended", Toast.LENGTH_SHORT).show()
                            contact_us_msg.setText("")
                        } catch (e: Exception) {
                            Log.e("exception", e.toString())
                        }
                    }
                }catch (e: Exception){
                    Log.e("exception",e.toString())
                }

            }

            override fun onFailure(call: Call<AllperalResponse>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                Log.e("data", t.toString())
            }
        })
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        Toast.makeText(this, "Selected : " + details[position], Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}