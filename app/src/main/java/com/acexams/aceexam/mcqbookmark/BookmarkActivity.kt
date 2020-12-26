
package com.acexams.aceexam.mcqbookmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.mcqbookmark.adapter.McqBookmarkAdapter
import com.acexams.aceexam.mcqbookmark.modal.BookMarkListModal
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.util.DialogUtils
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_bookmark.*
import kotlinx.android.synthetic.main.fragment_classes_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class BookmarkActivity : AppCompatActivity() {
    var userId:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)
        userId=shareprefrences.getStringPreference(this, "USER_ID").toString()


        bookmark_arrow_image.setOnClickListener {
            startActivity(Intent(this,SubjectBookmarkActivity::class.java))
        }

        bookmar_list()
        bookmark_back.setOnClickListener {
            onBackPressed()
        }
      //  mcqBookmarkAdapter= McqBookmarkAdapter(this,bokmarkList)

        bookmark_recycler.layoutManager = LinearLayoutManager(this)
       // bookmark_recycler.adapter = mcqBookmarkAdapter

    }

    fun bookmar_list() {
        DialogUtils.showProgressLoadingBar(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.bookmark_list(userId)
        call.enqueue(object : Callback<BookMarkListModal> {
            override fun onResponse(call: Call<BookMarkListModal>, response: Response<BookMarkListModal>) {
                DialogUtils.dismissProgressLoadingBar()

                try {
                    if (response.code()==200){
                        if (response.code() == 200) {
                            try {
                                bookmark_recycler.adapter = McqBookmarkAdapter(this@BookmarkActivity, response.body()!!.data)
                            } catch (e: Exception) {
                                Log.e("exception", e.toString())
                            }
                        } else {
                            Toast.makeText(this@BookmarkActivity, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this@BookmarkActivity, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                    }
                }catch (e:Exception){

                }


            }

            override fun onFailure(call: Call<BookMarkListModal>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                Log.e("data", t.toString())
            }
        })
    }
}