package com.acexams.aceexam.activity

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.acexams.aceexam.Model.SignupResponse
import com.app.politciannewapp.utils.MyProgressDialog
import com.card.visitingcardscanner.utils.AppUtils
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.SendotpRespone
import com.acexams.aceexam.user.LoginActivity
import com.rilixtech.widget.countrycodepicker.CountryCodePicker
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_collage_name_selection.*
import kotlinx.android.synthetic.main.fragment_video_classes.view.*
import okhttp3.ResponseBody
import org.json.JSONObject

class CollageNameSelectionActivity : AppCompatActivity() {
    var dialog: Dialog? = null
    var number: String? = null
    var code: String? = null
    lateinit var google_login_value:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collage_name_selection)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        google_login_value=shareprefrences.getStringPreference(this, "google_login").toString()
        Log.e("value_data",google_login_value)

        collegenameq.text = intent.getStringExtra("collegename").toString()
        txt_submit.setOnClickListener {
            opendialog()

        }
        backbutton_collage.setOnClickListener {
            onBackPressed()
        }
    }


    fun opendialog() {
        dialog = Dialog(this)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.dialog_onelaststep)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.findViewById<TextView>(R.id.getotp)?.setOnClickListener {
            if (dialog?.findViewById<EditText>(R.id.number)!!.text.isEmpty() || dialog?.findViewById<EditText>(
                    R.id.number
                )!!.text.toString().length != 10
            ) {
                Toast.makeText(this, "Please Enter Valid Number", Toast.LENGTH_SHORT).show()
            } else {
                number = dialog?.findViewById<EditText>(R.id.number)!!.text.toString()
                code=dialog?.findViewById<CountryCodePicker>(R.id.ccp)!!.defaultCountryCode.toString()
                sendsms(dialog!!, dialog?.findViewById<EditText>(R.id.number)!!.text.toString())
            }
        }
        dialog?.show()
    }


    fun verifyopendialog() {
        dialog = Dialog(this)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.dialog_verifyotp)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.findViewById<Button>(R.id.btn_sumit)?.setOnClickListener {
            if (dialog?.findViewById<EditText>(R.id.otppassword)!!.text.isEmpty()) {
                Toast.makeText(this, "Plz Enter Otp", Toast.LENGTH_SHORT).show()
            } else {
                otpverfied(
                    dialog!!,
                    dialog?.findViewById<EditText>(R.id.otppassword)!!.text.toString()
                )
                dialog?.dismiss()

            }


        }
        dialog?.findViewById<TextView>(R.id.resendotp)!!.setOnClickListener{
            resendsms()
        }
        dialog?.show()
    }


    private fun sendsms(dialog: Dialog, numer: String) {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("mobile", numer)
        hashMap.put("country_code", code.toString())
        hashMap.put("email", shareprefrences.getStringPreference(this, "email").toString())
        val call = apiService.sendotp(
            hashMap
        )
        call.enqueue(object : Callback<SendotpRespone> {
            override fun onResponse(
                call: Call<SendotpRespone>,
                response: Response<SendotpRespone>
            ) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        if (response.body()!!.status == 200) {
                            dialog?.dismiss()
                            verifyopendialog()
                        } else if (response.body()!!.status == 403) {
                            Toast.makeText(
                                this@CollageNameSelectionActivity,
                                response!!.body()!!.message,
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            AppUtils.showToast(
                                this@CollageNameSelectionActivity,
                                "Someting Went Wrong"
                            )
                        }
                    } catch (e: Exception) {
                        AppUtils.showToast(this@CollageNameSelectionActivity, "Someting Went Wrong")
                    }
                }
            }

            override fun onFailure(call: Call<SendotpRespone>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                AppUtils.showToast(this@CollageNameSelectionActivity, t.toString())
            }
        })
    }


    private fun resendsms() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("mobile", number.toString())
        hashMap.put("email", shareprefrences.getStringPreference(this, "email").toString())
        val call = apiService.sendotp(
            hashMap
        )
        call.enqueue(object : Callback<SendotpRespone> {
            override fun onResponse(
                call: Call<SendotpRespone>,
                response: Response<SendotpRespone>
            ) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        if (response.body()!!.status == 200) {
                            Toast.makeText(
                                this@CollageNameSelectionActivity,
                                "Resend OTP SUCESSFULLY",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (response.body()!!.status == 403) {
                            Toast.makeText(
                                this@CollageNameSelectionActivity,
                                response!!.body()!!.message,
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            AppUtils.showToast(
                                this@CollageNameSelectionActivity,
                                "Someting Went Wrong"
                            )
                        }
                    } catch (e: Exception) {
                        AppUtils.showToast(this@CollageNameSelectionActivity, "Someting Went Wrong")
                    }
                }
            }

            override fun onFailure(call: Call<SendotpRespone>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                AppUtils.showToast(this@CollageNameSelectionActivity, t.toString())
            }
        })
    }


    private fun otpverfied(dialog: Dialog, numer: String) {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("mobile", number.toString())
        hashMap.put("otp", numer.toString())

        val call = apiService.otpverified(hashMap)
        call.enqueue(object : Callback<SendotpRespone> {
            override fun onResponse(
                call: Call<SendotpRespone>,
                response: Response<SendotpRespone>
            ) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        if (response.body()!!.status == 200) { AppUtils.showToast(this@CollageNameSelectionActivity,
                                response!!.body()!!.message
                            )
                            if (google_login_value.equals("1")){
                                sigin()
                            }else{
                                signup()
                            }

                            dialog?.dismiss()
                        } else if (response!!.body()!!.status == 403) {
                            AppUtils.showToast(
                                this@CollageNameSelectionActivity,
                                response!!.body()!!.message
                            )
                        } else {
                            AppUtils.showToast(
                                this@CollageNameSelectionActivity,
                                "Someting Went Wrong"
                            )
                        }
                    } catch (e: Exception) {
                        AppUtils.showToast(this@CollageNameSelectionActivity, "Someting Went Wrong")
                    }
                }

            }

            override fun onFailure(call: Call<SendotpRespone>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                AppUtils.showToast(this@CollageNameSelectionActivity, t.toString())
            }
        })
    }


    private fun signup() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("name", shareprefrences.getStringPreference(this, "name").toString())
        hashMap.put("email", shareprefrences.getStringPreference(this, "email").toString())
        hashMap.put("mobile", number.toString())
        hashMap.put("password", shareprefrences.getStringPreference(this, "password").toString())
        hashMap.put("college_id", shareprefrences.getStringPreference(this, "collegeid").toString())
        hashMap.put("year_id", shareprefrences.getStringPreference(this, "yearid").toString())
        hashMap.put("exam_id", shareprefrences.getStringPreference(this, "examid").toString())
        hashMap.put("complete_process",shareprefrences.getStringPreference(this, "google_login").toString())

        hashMap.put("address", "ghvhd")
        val call = apiService.signup(
            hashMap
        )
        call.enqueue(object : Callback<SignupResponse> {
            override fun onResponse(
                call: Call<SignupResponse>,
                response: Response<SignupResponse>
            ) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {
                        if (response.body()!!.status == 200) {
                            startActivity(
                                Intent(
                                    this@CollageNameSelectionActivity,
                                    LoginActivity::class.java
                                )
                            )
                            ActivityCompat.finishAffinity(this@CollageNameSelectionActivity)
                        } else if (response.code() == 403) {
                            AppUtils.showToast(
                                this@CollageNameSelectionActivity,
                                "The email has already been taken"
                            )
                        } else {
                            AppUtils.showToast(
                                this@CollageNameSelectionActivity,
                                "Someting Went Wrong"
                            )
                        }
                    } catch (e: Exception) {
                        AppUtils.showToast(this@CollageNameSelectionActivity, "Someting Went Wrong")
                    }
                }

            }

            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                AppUtils.showToast(this@CollageNameSelectionActivity, t.toString())
            }
        })
    }


    private fun sigin() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("name", shareprefrences.getStringPreference(this, "name").toString())
        hashMap.put("email", shareprefrences.getStringPreference(this, "email").toString())
        hashMap.put("mobile", number.toString())
        hashMap.put("password", shareprefrences.getStringPreference(this, "password").toString())
        hashMap.put("college_id", shareprefrences.getStringPreference(this, "collegeid").toString())
        hashMap.put("year_id", shareprefrences.getStringPreference(this, "yearid").toString())
        hashMap.put("exam_id", shareprefrences.getStringPreference(this, "examid").toString())
        hashMap.put("complete_process",shareprefrences.getStringPreference(this, "google_login").toString())
        hashMap.put("fcm_id","")
        hashMap.put("is_social_login","1")
        val call = apiService.login(
            hashMap
        )
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    try {


                        var obj= response.body()!!.string()
                        var json= JSONObject(obj)
                        var status=json.getString("status")

                        if (status.toInt()==200){
                            var message=json.getString("message")
                            var jsonone=json.getJSONObject("data")
                            var token=jsonone.getString("token")
                            var id=jsonone.getString("id")
                            shareprefrences.setStringPreference(this@CollageNameSelectionActivity, "USER_ID", id)
                            shareprefrences.setStringPreference(
                                this@CollageNameSelectionActivity, "ACCESS_TOKEN", token)
                            Toast.makeText(this@CollageNameSelectionActivity, message, Toast.LENGTH_SHORT).show()
                            var intent = Intent(this@CollageNameSelectionActivity, DashBoardActivity::class.java)
                            startActivity(intent)
                            finish()

                        }else{
                            Toast.makeText(this@CollageNameSelectionActivity,"Something went wrong",Toast.LENGTH_SHORT).show()
                        }

                    } catch (e: Exception) {
                        AppUtils.showToast(this@CollageNameSelectionActivity, "Someting Went Wrong")
                    }
                }

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                AppUtils.showToast(this@CollageNameSelectionActivity, t.toString())
            }
        })
    }




}
