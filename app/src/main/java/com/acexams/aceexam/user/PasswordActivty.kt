package com.acexams.aceexam.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import com.app.politciannewapp.utils.MyProgressDialog
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.DashBoardActivity
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_password_activty.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.regex.Matcher
import java.util.regex.Pattern


class PasswordActivty : AppCompatActivity(), View.OnClickListener {
    lateinit var password: String
    lateinit var email: String
    lateinit var confirm_password: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_activty)
        email = intent.getStringExtra("emmail").toString()
        tv_passwordimage.setOnClickListener(this)
        tv_confrimimage.setOnClickListener(this)
        backpassword.setOnClickListener {
            onBackPressed()
        }

        btn_password.setOnClickListener {
            password = edt_password.text.toString().trim()
            confirm_password = edt_confrm_password.text.toString().trim()
            if (!isValidPassword(password)) {
                edt_password.setError("Invalid Password")

            } else if (!confirm_password.equals(password)) {
                edt_confrm_password.setError("Enter Same Password")

            } else {
                wrongDtata()
            }

        }
    }

    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+!=])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }

    fun wrongDtata() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.verifyEmail(
            email,
            password
        )
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        var myobj = response.body()?.string()
                        var json = JSONObject(myobj)
                        var status = json.getString("status")
                        var message = json.getString("message")
                        if (status.toInt() == 200) {
                            Log.e("login", response.body().toString())
                            Toast.makeText(this@PasswordActivty, message, Toast.LENGTH_SHORT).show()
                            startActivity(
                                Intent(
                                    this@PasswordActivty,
                                    DashBoardActivity::class.java
                                )
                            )
                        } else if (status.toInt() == 401) {
                            Toast.makeText(
                                this@PasswordActivty,
                                "invalid credentials",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else if (status.toInt() == 201) {
                            Toast.makeText(this@PasswordActivty, message, Toast.LENGTH_SHORT).show()
                            var intent = Intent(this@PasswordActivty, NameActivity::class.java)
                            intent.putExtra("password", password)
                            intent.putExtra("email", email)
                            startActivity(intent)
                        }
                    } catch (e: Exception) {
                        Log.e("exception", e.toString())
                    }
                }


            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data", t.toString())

            }

        })
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_passwordimage -> {
                if (edt_password.getTransformationMethod()
                        .equals(PasswordTransformationMethod.getInstance())
                ) {
                    tv_passwordimage.setImageResource(R.drawable.showpassword)
                    edt_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    tv_passwordimage.setImageResource(R.drawable.hidepasswrod)
                    edt_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
            R.id.tv_confrimimage -> {
                if (edt_confrm_password.getTransformationMethod()
                        .equals(PasswordTransformationMethod.getInstance())
                ) {
                    tv_confrimimage.setImageResource(R.drawable.showpassword)
                    edt_confrm_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    tv_confrimimage.setImageResource(R.drawable.hidepasswrod)
                    edt_confrm_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        }
    }

}