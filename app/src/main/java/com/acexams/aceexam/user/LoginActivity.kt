package com.acexams.aceexam.user

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
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
import com.acexams.aceexam.activity.ForgetPasswordActivity
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shareprefrences
import java.lang.Exception
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var name: String
    lateinit var password: String
    lateinit var firebase_token:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        backemail.setOnClickListener {
            onBackPressed()
        }
        init()
        tv_password_image.setOnClickListener(this)

        //==========Notification=============
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            var channel=NotificationChannel(
                "MyNotification","MyNotification",NotificationManager.IMPORTANCE_DEFAULT)
            var manager=getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)

        }
        firebase_token = shareprefrences.getStringPreference(this, "FCM_TOKEN").toString()
        Log.e("fcm_token",firebase_token)
    }


    fun init() {
        btn_login.setOnClickListener {
            validation()
        }
        forgetpassword.setOnClickListener {
            var intent = Intent(this@LoginActivity, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    fun validation() {
        name = edt_email.text.toString()
        password = edt_password.text.toString()



        if (name.isEmpty()) {
            edt_email.error = "Enter Email Id Or Number"
        } else if (password.isEmpty()) {
            edt_password.error = "Enter Password"
        } else {
            login()
        }
    }



    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_password_image -> {
                if (edt_password.getTransformationMethod()
                        .equals(PasswordTransformationMethod.getInstance())
                ) {
                    tv_password_image.setImageResource(R.drawable.showpassword)
                    edt_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    tv_password_image.setImageResource(R.drawable.hidepasswrod)
                    edt_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
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


    private fun login() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("email", edt_email.text.toString())
        hashMap.put("password", edt_password.text.toString())
        hashMap.put("fcm_id",firebase_token)
        hashMap.put("is_social_login","0")
        val call = apiService.login(
            hashMap
        )
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                try {
                    MyProgressDialog.dismissProgress()

                    var obj= response.body()!!.string()
                    var json=JSONObject(obj)
                    var status=json.getString("status")

                    if (status.toInt()==200){
                        var message=json.getString("message")
                        var jsonone=json.getJSONObject("data")
                        var token=jsonone.getString("token")
                        var id=jsonone.getString("id")
                        shareprefrences.setStringPreference(this@LoginActivity, "USER_ID", id)
                        shareprefrences.setStringPreference(
                            this@LoginActivity, "ACCESS_TOKEN", token)
                        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
                        var intent = Intent(this@LoginActivity, DashBoardActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                    else if (status.toInt()==401){
                        var message=json.getString("message")
                        Toast.makeText(this@LoginActivity,message,Toast.LENGTH_SHORT).show()
                    }


                } catch (e: Exception) {
                    println("Anshu exception " + e.message)
                    Log.e("error", e.toString())
                }


            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                println("Anshu failed " + t.message)
                Log.e("error", t.toString())
            }

        })
    }
}