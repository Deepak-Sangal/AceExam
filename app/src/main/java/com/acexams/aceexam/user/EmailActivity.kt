package com.acexams.aceexam.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.app.politciannewapp.utils.MyProgressDialog
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.EmailVerifiyResponse
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_email.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class EmailActivity : AppCompatActivity() {

    lateinit var useremailid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        backemail.setOnClickListener {
            onBackPressed()
        }

        btn_email.setOnClickListener {

            validation()

        }
    }

    fun validation() {
        useremailid = edt_email_id.text.toString()
        if (!isValid(useremailid)) {
            edt_email_id.requestFocus()
            edt_email_id.error = "Enter Valid email"

        } else {
            email()

        }
    }

    fun isValid(email: String?): Boolean {
        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"
        val pat = Pattern.compile(emailRegex)
        return if (email == null) false else pat.matcher(email).matches()
    }


    fun email() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.matchemail(
            edt_email_id.text.toString(),
        )
        call.enqueue(object : Callback<EmailVerifiyResponse> {
            override fun onResponse(
                call: Call<EmailVerifiyResponse>,
                response: Response<EmailVerifiyResponse>
            ) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    if (response.body()!!.status == 201) {
                        var intent = Intent(this@EmailActivity, PasswordActivty::class.java)
                        intent.putExtra("emmail", useremailid)
                        startActivity(intent)
                    } else if (response.body()!!.status == 200) {
                        Toast.makeText(
                            this@EmailActivity,
                            "You are aready Resister, Please Login with your Password",
                            Toast.LENGTH_SHORT
                        ).show()

                        Handler().postDelayed({
                            var intent = Intent(this@EmailActivity, LoginActivity::class.java)
                            intent.putExtra("emmail", useremailid)
                            startActivity(intent)

                        }, 2000)

                    }

                } else {
                    Toast.makeText(this@EmailActivity, "Something Went Wrong", Toast.LENGTH_SHORT)
                        .show()
                }


            }

            override fun onFailure(call: Call<EmailVerifiyResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data", t.toString())

            }

        })
    }

}