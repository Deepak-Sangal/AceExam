package com.acexams.aceexam.activity

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
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.app.politciannewapp.utils.MyProgressDialog
import com.card.visitingcardscanner.utils.AppUtils
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.EmailVerifiyResponse
import com.acexams.aceexam.activity.modal.SendotpRespone
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_forget_password.*
import kotlinx.android.synthetic.main.activity_forget_password.btn_email
import kotlinx.android.synthetic.main.dialog_verifyotp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class ForgetPasswordActivity : AppCompatActivity() {
    lateinit var useremailid:String
    var dialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

        backemail.setOnClickListener{
            onBackPressed()
        }
        btn_email.setOnClickListener {
            validation()

        }
    }

    fun validation(){
        useremailid=edt_email_id_forget.text.toString()
        if (!isValid(useremailid)) {
            edt_email_id_forget.requestFocus()
            edt_email_id_forget.error = "Enter Valid email"

        }
        else{
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
            edt_email_id_forget.text.toString(),
        )
        call.enqueue(object : Callback<EmailVerifiyResponse> {
            override fun onResponse(call: Call<EmailVerifiyResponse>, response: Response<EmailVerifiyResponse>) {
                MyProgressDialog.dismissProgress()
                if(response.code()==200){
                    if(response.body()!!.status==201){
                        Toast.makeText(this@ForgetPasswordActivity,"Please Enter Vaild Email-id ", Toast.LENGTH_SHORT).show()
                    }else if(response.body()!!.status==200){
                        sendotp()
//                        verifyopendialog()
                    }

                }else{
                    Toast.makeText(this@ForgetPasswordActivity,"Something Went Wrong", Toast.LENGTH_SHORT).show()
                }


            }

            override fun onFailure(call: Call<EmailVerifiyResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data",t.toString())

            }

        })
    }


    fun verifyopendialog(){
        dialog = Dialog(this)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.dialog_verifyotp)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.findViewById<TextView>(R.id.changenumber)!!.visibility=View.GONE
        dialog?.findViewById<Button>(R.id.btn_sumit)?.setOnClickListener{
            if( dialog?.findViewById<EditText>(R.id.otppassword)!!.text.isEmpty()){
                Toast.makeText(this,"Plz Enter Otp",Toast.LENGTH_SHORT).show()
            }else{
                verfiedotp(dialog?.findViewById<EditText>(R.id.otppassword)!!.text.toString())
            }

        }
        dialog?.show()
    }


    private fun sendotp() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("email", edt_email_id_forget.text.toString())
        val call = apiService.forgotPasswordSendSms(
            hashMap
        )
        call.enqueue(object : Callback<SendotpRespone> {


            override fun onResponse(call: Call<SendotpRespone>, response: Response<SendotpRespone>) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        if (response.body()!!.status == 200) {
                            verifyopendialog()
                        }
                        else if (response.code() == 403) {
                            AppUtils.showToast(this@ForgetPasswordActivity, response!!.body()!!.message)
                        } else {
                            AppUtils.showToast(this@ForgetPasswordActivity, "Someting Went Wrong")
                        }
                    }catch (e:Exception){
                        AppUtils.showToast(this@ForgetPasswordActivity, "Someting Went Wrong")
                    }


                }

            }

            override fun onFailure(call: Call<SendotpRespone>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                AppUtils.showToast(this@ForgetPasswordActivity, t.toString())
            }
        })
    }

    private fun verfiedotp(otp:String) {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("email", edt_email_id_forget.text.toString())
        hashMap.put("otp", otp)
        val call = apiService.forgotPasswordValidateOTP(
            hashMap
        )
        call.enqueue(object : Callback<SendotpRespone> {


            override fun onResponse(call: Call<SendotpRespone>, response: Response<SendotpRespone>) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        if (response.body()!!.status == 200) {
                            dialog?.dismiss()
                            AppUtils.showToast(this@ForgetPasswordActivity, response!!.body()!!.message)
                            var intent= Intent(this@ForgetPasswordActivity, ChangePasswordActivity::class.java)
                            intent.putExtra("emmail",useremailid)
                            startActivity(intent)
                        }
                        else if (response.code() == 403) {
                            AppUtils.showToast(this@ForgetPasswordActivity, response!!.body()!!.message)
                        } else {
                            AppUtils.showToast(this@ForgetPasswordActivity, "Someting Went Wrong")
                        }
                    }catch (e:Exception){
                        AppUtils.showToast(this@ForgetPasswordActivity, "Someting Went Wrong")
                    }


                }

            }

            override fun onFailure(call: Call<SendotpRespone>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                AppUtils.showToast(this@ForgetPasswordActivity, t.toString())
            }
        })
    }
}