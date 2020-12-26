package com.acexams.aceexam.peral

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.AllperalResponse
import com.acexams.aceexam.adapter.PearlsAdapter
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.util.DialogUtils
import com.talkingtb.talkingtb.remote.ApiClient
import kotlinx.android.synthetic.main.fragment_pearls_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class PearlsFragement : Fragment() {
    var userId:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pearls_fragement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        perlrecyle.layoutManager = LinearLayoutManager(activity)
        userId=shareprefrences.getStringPreference(activity!!, "USER_ID").toString()
        click.setOnClickListener(View.OnClickListener {
            if (perlrecyle.visibility == View.VISIBLE) {
                perlrecyle.visibility = View.GONE
                Glide.with(activity!!).load(R.drawable.right).into(click)
            } else {
                perlrecyle.visibility = View.VISIBLE
                Glide.with(activity!!).load(R.drawable.downarrow).into(click)
            }

        })
        pearls()
    }

    fun pearls() {
        DialogUtils.showProgressLoadingBar(context)
        pb.visibility = View.VISIBLE
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.allpearls(
            "Bearer" + shareprefrences.getStringPreference(requireContext(), "ACCESS_TOKEN")
                .toString(),userId
        )
        call.enqueue(object : Callback<AllperalResponse> {
            override fun onResponse(call: Call<AllperalResponse>, response: Response<AllperalResponse>) {
                pb.visibility = View.GONE
                DialogUtils.dismissProgressLoadingBar()
                try {
                    if (response.code() == 200) {
                        try {
                            if (response.body()!!.status==200){
                                val list = response.body()?.data
                                perlrecyle.adapter = PearlsAdapter(activity!!, list!!)
                            }

                        } catch (e: Exception) {
                            Log.e("exception", e.toString())
                        }
                    }
                }catch (e:Exception){
                    Log.e("exception",e.toString())
                }

            }

            override fun onFailure(call: Call<AllperalResponse>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                pb.visibility = View.GONE
                Log.e("data", t.toString())
            }
        })
    }

}