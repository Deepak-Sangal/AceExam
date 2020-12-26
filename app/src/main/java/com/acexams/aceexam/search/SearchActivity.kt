package com.acexams.aceexam.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.SearchResponse
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.search.adapter.SearchAdapter
import com.app.politciannewapp.utils.MyProgressDialog
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_view_palns.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class SearchActivity : AppCompatActivity(),
    androidx.appcompat.widget.SearchView.OnQueryTextListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        search_war.setOnQueryTextListener(this)
        searchrecycle.layoutManager=LinearLayoutManager(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { plan(it) }
       return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


    fun plan(key:String) {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.search(
            "Bearer" + shareprefrences.getStringPreference(this, "ACCESS_TOKEN").toString(),
            key
        )
        call.enqueue(object : Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                MyProgressDialog.dismissProgress()
                if(response.code()==200){
                    if(response.body()!!.status==200) {
                        try {
                            searchrecycle.adapter =
                                SearchAdapter(this@SearchActivity, response.body()!!.data)
                        } catch (e: Exception) {
                            Log.e("exception", e.toString())
                        }
                    }else{
                        Toast.makeText(this@SearchActivity,"Something Went Wrong", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                Log.e("data",t.toString())

            }
        })
    }

}