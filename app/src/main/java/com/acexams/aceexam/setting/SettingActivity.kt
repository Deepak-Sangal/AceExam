package com.acexams.aceexam.setting

import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.acexams.aceexam.Model.GetProfileResponse
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.CommonActivity
import com.acexams.aceexam.activity.CourseSelectionActivity
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.user.LoginActivity
import com.acexams.aceexam.user.UserProfileActivity
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_setting.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shareprefrences


class SettingActivity : AppCompatActivity() {
     var token:String=""
     var id:String=""
    var progressDoalog: ProgressDialog? = null
    lateinit var course:String
    lateinit var google_login_value:String
    lateinit var  mGoogleSignInClient: GoogleSignInClient
    lateinit var userName:String
    lateinit var mAuth:FirebaseAuth
    lateinit var dialog:Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)


        id=shareprefrences.getStringPreference(this, "USER_ID").toString()
        token=shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString()
        google_login_value=shareprefrences.getStringPreference(this, "google_login").toString()
        Log.e("value_data", google_login_value)

        mAuth= FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        backbutton_setting.setOnClickListener {
            onBackPressed()
        }

        progressDoalog =  ProgressDialog(this);
        progressDoalog!!.setMax(100);
        progressDoalog!!.setMessage("Its loading....");
        progressDoalog!!.setTitle("ProgressDialog bar example");


        editprofile.setOnClickListener{
            startActivity(Intent(this, UserProfileActivity::class.java))
        }
        logout.setOnClickListener{
            opendialog()
        }

    /*    txt_change_password.setOnClickListener {
            startActivity(Intent(this,ChangePasswordActivity::class.java))
        }    */
        profile()

        txt_couser_selection.setOnClickListener {
            startActivity(Intent(this, CourseSelectionActivity::class.java).putExtra("home", "1"))
        }

//        txt_couser_selection.text=(course)

    }


    fun dialig() {

        AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
            .setMessage("Are you sure you want to Logout")
            .setPositiveButton("LOGOUT",
                DialogInterface.OnClickListener {

                        dialog, which ->
                    finish();

                    if (google_login_value.equals("1")) {
                        logout()
                    } else {
                        shareprefrences.clearAllPreferences(this);
                        startActivity(Intent(this, CommonActivity::class.java));
                        ActivityCompat.finishAffinity(this);
                    }


                })
            .setNegativeButton("CANCEL", null).show()
    }


    private fun profile() {
        progressDoalog?.show();

        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getprofile(
            "Bearer " + token,
            id

        )
        call.enqueue(object : Callback<GetProfileResponse> {
            override fun onResponse(
                call: Call<GetProfileResponse>,
                response: Response<GetProfileResponse>
            ) {
                progressDoalog!!.dismiss();
                try {
                    if (response.code() == 200) {

                        if (response.body()!!.data.exam_name != null) {
                            var exam_name = response.body()!!.data.exam_name.toString()
                            Log.e("examnidhi", exam_name)
                            txt_couser_selection.text = exam_name
                        }

                        var image = response.body()!!.data.image
                        if (image.equals("")) {
                            image_profile.setBackgroundDrawable(
                                ContextCompat.getDrawable(
                                    this@SettingActivity,
                                    R.drawable.profile
                                )
                            );
                        }
                        else {
                            var const = "http://www.acexam.com/web/public/uploads/students/profile/"
                            Glide.with(this@SettingActivity)
                                .load(const + image)
                                .into(image_profile);
                        }




                    }
                } catch (e: Exception) {
                    Log.e("error", e.toString())
                }


            }

            override fun onFailure(call: Call<GetProfileResponse>, t: Throwable) {
                progressDoalog!!.dismiss();
                Toast.makeText(this@SettingActivity, "invalid credentials", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }


    fun logout(){
        mGoogleSignInClient.signOut()
        Toast.makeText(this, "You are Logged Out", Toast.LENGTH_SHORT).show()
        shareprefrences.clearAllPreferences(this);
        startActivity(Intent(this, CommonActivity::class.java));
        ActivityCompat.finishAffinity(this);
    }

    fun opendialog() {

        dialog = Dialog(this)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.logout)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.findViewById<Button>(R.id.tv_logout)?.setOnClickListener {
            dialog.dismiss()
            if (google_login_value.equals("1")) {
                logout()
            } else {
                shareprefrences.clearAllPreferences(this);
                startActivity(Intent(this, CommonActivity::class.java));
                ActivityCompat.finishAffinity(this);
            }
        }
        dialog?.findViewById<TextView>(R.id.tv_cancle)?.setOnClickListener {
            dialog.dismiss()
        }

        dialog?.show()
    }


}