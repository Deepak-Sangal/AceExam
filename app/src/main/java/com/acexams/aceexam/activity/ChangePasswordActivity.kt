package com.acexams.aceexam.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.app.politciannewapp.utils.MyProgressDialog
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.ChangePasswordResponse
import com.acexams.aceexam.user.LoginActivity
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_change_password.*
import kotlinx.android.synthetic.main.activity_change_password.backpassword
import kotlinx.android.synthetic.main.activity_change_password.btn_password
import kotlinx.android.synthetic.main.activity_change_password.edt_confrm_password
import kotlinx.android.synthetic.main.activity_change_password.edt_password
import kotlinx.android.synthetic.main.activity_change_password.tv_confrimimage
import kotlinx.android.synthetic.main.activity_change_password.tv_passwordimage

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Matcher
import java.util.regex.Pattern

class ChangePasswordActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var password:String
    lateinit var email:String
    lateinit var confirm_password:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        email=intent.getStringExtra("emmail").toString()
        tv_passwordimage.setOnClickListener(this)
        tv_confrimimage.setOnClickListener(this)
        backpassword.setOnClickListener{
            onBackPressed()
        }
        btn_password.setOnClickListener {
            password=edt_password.text.toString().trim()
            confirm_password=edt_confrm_password.text.toString().trim()
            if (!isValidPassword(password)) {
                edt_password.setError("Invalid Password")

            }else if (!confirm_password.equals(password)){
                edt_confrm_password.setError("Enter Same Password")

            }
            else {
                wrongDtata()
            }

        }

    }

    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tv_passwordimage->{
                if(edt_password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    tv_passwordimage.setImageResource(R.drawable.showpassword)
                    edt_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    tv_passwordimage.setImageResource(R.drawable.hidepasswrod)
                    edt_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
            R.id.tv_confrimimage->{
                if(edt_confrm_password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    tv_confrimimage.setImageResource(R.drawable.showpassword)
                    edt_confrm_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    tv_confrimimage.setImageResource(R.drawable.hidepasswrod)
                    edt_confrm_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        }
    }

    fun wrongDtata() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.change_password(
            email,
            password
        )
        call.enqueue(object : Callback<ChangePasswordResponse> {
            override fun onResponse(call: Call<ChangePasswordResponse>, response: Response<ChangePasswordResponse>) {
                MyProgressDialog.dismissProgress()
                if(response.code()==200){
                    if(response.body()!!.status==200){
                        Toast.makeText(this@ChangePasswordActivity,"Password Changed",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@ChangePasswordActivity, LoginActivity::class.java))
                        ActivityCompat.finishAffinity(this@ChangePasswordActivity);
                    }else{
                        Toast.makeText(this@ChangePasswordActivity,"Something went wrong",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<ChangePasswordResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data",t.toString())
            }
        })
    }

}