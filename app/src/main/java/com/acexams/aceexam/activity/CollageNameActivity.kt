package com.acexams.aceexam.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.adpater.CollegelistAdapter
import com.acexams.aceexam.activity.modal.CollegeResponse
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_collage_name.*
import kotlinx.android.synthetic.main.activity_state_selection.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class CollageNameActivity : AppCompatActivity() {
    lateinit var stateid: String
    lateinit var list: List<CollegeResponse.Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collage_name)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        stateid = intent.getStringExtra("stateid").toString()
        collegename.setOnClickListener {
            onBackPressed()
        }

        collegerecycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        collgedata()
        lisner()
//        txt_collage_name.setOnClickListener {
//            startActivity(Intent(this,CollageNameSelectionActivity::class.java))
//        }
    }

    private fun lisner() {
        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                var templist = ArrayList<CollegeResponse.Data>()
                list.forEach {
                    if (it.name.toLowerCase().contains(s.toString().toLowerCase())) {
                        templist.add(it)
                    }
                }
                collegerecycle.adapter = CollegelistAdapter(this@CollageNameActivity, templist)
            }

        })
    }


    fun collgedata() {

        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getcollge(stateid)
        call.enqueue(object : Callback<CollegeResponse> {
            override fun onResponse(
                call: Call<CollegeResponse>,
                response: Response<CollegeResponse>
            ) {
                if (response.code() == 200) {
                    try {
                        list = response!!.body()!!.data
                        collegerecycle.adapter =
                            CollegelistAdapter(this@CollageNameActivity, response!!.body()!!.data)
                    } catch (e: Exception) {
                        Log.e("exception", e.toString())
                    }
                } else {
                    Toast.makeText(
                        this@CollageNameActivity,
                        "Something Went Wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }

            override fun onFailure(call: Call<CollegeResponse>, t: Throwable) {
                Log.e("data", t.toString())

            }

        })
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)

    }
}