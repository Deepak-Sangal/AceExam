package com.acexams.aceexam.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.acexams.aceexam.R
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.user.EmailActivity
import com.acexams.aceexam.user.LoginActivity
import com.app.politciannewapp.utils.MyProgressDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_common.*
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shareprefrences

class CommonActivity : AppCompatActivity() {

    lateinit var  mGoogleSignInClient: GoogleSignInClient
    var TAG="Login"
    lateinit var mAuth: FirebaseAuth
    private val RC_SIGN_IN = 234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )


        //................Google Sign In..............
        mAuth= FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        requestPermission()
        if (shareprefrences.getStringPreference(this!!, "ACCESS_TOKEN").toString().isNotEmpty()) {
            var intent = Intent(this, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }

        bnt_sign_up.setOnClickListener {
            startActivity(Intent(this, EmailActivity::class.java))
        }
        common_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }



        google_sign.setOnClickListener {
            googleSign()
        }
    }

    fun requestPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.CALL_PHONE
                ),
                1
            );

        }
    }



    ////===================Google==============
    private fun googleSign() {
        val signInIntent = mGoogleSignInClient.signInIntent

        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === RC_SIGN_IN) {

            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            handleSignInResulyt(task)

            /*try {

                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    firebaseAuthWithGoogle(account)
                }
            } catch (e: ApiException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }*/
        }
    }

    private fun handleSignInResulyt(completedTask: Task<GoogleSignInAccount>?) {

        try {

            var account=completedTask?.getResult(ApiException::class.java)

            Toast.makeText(this, "Sign in sucessfully", Toast.LENGTH_SHORT).show()

            FirebaseGoogleAuth(account)

        }catch (e: ApiException){
            FirebaseGoogleAuth(null)
            Toast.makeText(this, "Sign in Unsucessfully", Toast.LENGTH_SHORT).show()
        }

    }

    private fun FirebaseGoogleAuth(account: GoogleSignInAccount?) {
        var authCredential= GoogleAuthProvider.getCredential(account?.idToken, null)
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(account?.idToken)
//            .requestEmail()
//            .build()
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, OnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Sucessfully", Toast.LENGTH_SHORT).show()
                var user = mAuth.currentUser
                UpdateUI(user)
            } else {
                UpdateUI(null)
                //  Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun UpdateUI(user: FirebaseUser?) {
        var account=GoogleSignIn.getLastSignedInAccount(applicationContext)
        if (account!=null){
            var username=account.displayName.toString()
            var personGivenName=account.givenName
            var personFamilyName=account.familyName
            var personEmailId=account.email.toString()
            var personId=account.id
            var personPicture=account.photoUrl
            Toast.makeText(this, username, Toast.LENGTH_SHORT).show()
            login(personEmailId, username)
          /*  var intent=Intent(this,MainActivity::class.java)
            intent.putExtra("name",username)
            startActivity(intent)*/

        }

    }

    private fun login(email: String, name: String) {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("email", email)
        hashMap.put("password", "")
        hashMap.put("fcm_id", "")
        hashMap.put("is_social_login", "1")
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

                    var obj = response.body()!!.string()
                    var json = JSONObject(obj)
                    var status = json.getString("status")

                    if (status.toInt() == 200) {
                        var message = json.getString("message")
                        var jsonone = json.getJSONObject("data")
                        var token = jsonone.getString("token")
                        var id = jsonone.getString("id")
                        shareprefrences.setStringPreference(this@CommonActivity, "USER_ID", id)
                        shareprefrences.setStringPreference(
                            this@CommonActivity, "ACCESS_TOKEN", token
                        )
                        shareprefrences.setStringPreference(
                            this@CommonActivity,
                            "google_login",
                            "1"
                        )
                        Toast.makeText(this@CommonActivity, message, Toast.LENGTH_SHORT).show()
                        var intent = Intent(this@CommonActivity, DashBoardActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else if (status.toInt() == 201) {
                        var message = json.getString("message")
                        shareprefrences.setStringPreference(this@CommonActivity, "name", name)
                        shareprefrences.setStringPreference(this@CommonActivity, "email", email)
                        shareprefrences.setStringPreference(
                            this@CommonActivity,
                            "google_login",
                            "1"
                        )
                        Toast.makeText(this@CommonActivity, message, Toast.LENGTH_SHORT).show()
                        startActivity(
                            Intent(
                                this@CommonActivity,
                                CourseSelectionActivity::class.java
                            )
                        )
                        finish()
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