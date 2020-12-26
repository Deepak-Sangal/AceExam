package com.acexams.aceexam.progresstracker

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.acexams.aceexam.R
import com.acexams.aceexam.progresstracker.modal.ProgressBarModal
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.util.DialogUtils
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.talkingtb.talkingtb.remote.ApiClient

import kotlinx.android.synthetic.main.activity_progress_tracker.*
import kotlinx.android.synthetic.main.fragment_classes_fragement.*
import kotlinx.android.synthetic.main.fragment_home_fragement.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

lateinit var userId:String
class ProgressTrackerActivity : AppCompatActivity() {
    var date: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_tracker)

        userId = shareprefrences.getStringPreference(this, "USER_ID").toString()
        finddate()
//        weeklyChart()
        tracker_back.setOnClickListener {
            onBackPressed()
        }
        course()



        tracker_weekly.setOnClickListener {
            tracker_weekly.setBackgroundResource(R.drawable.cornerswithfill)
            tracker_weekly.setTextColor(Color.parseColor("#ffffff"))
            tracker_monthly.setBackgroundResource(R.drawable.greycorners)
            tracker_monthly.setTextColor(Color.parseColor("#000000"))

//            barchart.visibility = View.VISIBLE
//            scatterChart.visibility = View.GONE

            trak_date.text = "21 Sept - 28 Sept"

        }

        tracker_monthly.setOnClickListener {
            tracker_monthly.setBackgroundResource(R.drawable.cornerswithfill)
            tracker_monthly.setTextColor(Color.parseColor("#ffffff"))
            tracker_weekly.setBackgroundResource(R.drawable.greycorners)
            tracker_weekly.setTextColor(Color.parseColor("#000000"))

//            barchart.visibility = View.GONE
//            scatterChart.visibility = View.VISIBLE

            trak_date.text = "September"

        }

    }


    private fun weeklyChart() {

//        initChart()
        11

    }

//   private fun monthlyChart(){
//        var scatterEntries: ArrayList<BarEntry> = ArrayList()
//        scatterChart as ScatterChart
//        scatterEntries.add(BarEntry(2f, 0))
//        scatterEntries.add(BarEntry(4f, 1))
//        scatterEntries.add(BarEntry(6f, 1))
//        scatterEntries.add((BarEntry8f, 3))
//        scatterEntries.add(BarEntry(7f, 4))
//        scatterEntries.add(BarEntry(3f, 3))
//        var scatterDataSet = ScatterDataSet(scatterEntries as List<Entry>?, "cells")
//        var scatterData: ScatterDataSet = scatterDataSet
////        scatterChart.data = scatterData
//
//    }

    private fun initChart() {

        barchart as BarChart
        val entries: ArrayList<BarEntry> = ArrayList()
        entries.add(BarEntry(8f, 0))
        entries.add(BarEntry(2f, 1))
        entries.add(BarEntry(5f, 2))
        entries.add(BarEntry(20f, 3))
        entries.add(BarEntry(15f, 4))
        entries.add(BarEntry(19f, 5))
        entries.add(BarEntry(20f, 6))

        val barDataSet = BarDataSet(entries, "Cells")

        val labels = ArrayList<String>()

        labels.add("21 \nM")
        labels.add("22 \nT")
        labels.add("23 \nW")
        labels.add("24 \nT")
        labels.add("25 \nF")
        labels.add("26 \nS")
        labels.add("27 \nS")

        val data = BarData(labels, barDataSet)
        barchart.data = data

    }


    fun course() {
        DialogUtils.showProgressLoadingBar(this)
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getTracker(userId,date)
        call.enqueue(object : Callback<ProgressBarModal> {
            override fun onResponse(
                call: Call<ProgressBarModal>,
                response: Response<ProgressBarModal>
            ) {
                DialogUtils.dismissProgressLoadingBar()
                if (response.code() == 200) {
                    barchart as BarChart
                    val entries: ArrayList<BarEntry> = ArrayList()
                    val labels = ArrayList<String>()

                    for (i in 1..response.body()!!.data.size-1) {
                        entries.add(BarEntry((response.body()!!.data[i].topic_completed).toFloat(), i))
                        labels.add((response.body()!!.data[i].date_of_completion))
                    }
                    val barDataSet = BarDataSet(entries, "Cells")
                    val data = BarData(labels, barDataSet)
                    barchart.data = data
//                    txt_progress_one.text = "Date: " + response.body()!!.data[0].date_of_completion
//                    txt_progress_two.text =
//                        "Date: " + response.body()!!.data[1].date_of_completion + "" + response.body()!!.data[0].topic_completed
//
//                    txt_complete_one.text =
//                        "Topic Complete: " + response.body()!!.data[0].topic_completed
//                    txt_complete_two.text =
//                        "Topic Complete: " + response.body()!!.data[1].topic_completed

                } else if (response.code()==404){
                    Toast.makeText(
                        this@ProgressTrackerActivity,
                        "No Data Found",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ProgressBarModal>, t: Throwable) {
                DialogUtils.dismissProgressLoadingBar()
                Log.e("data", t.toString())
            }
        })
    }


    fun finddate() {
        val cDate = Date()
        val fDate: String = SimpleDateFormat("yyyy-MM-dd").format(cDate)
        date = fDate;
        Log.e("data", fDate)
//        initChart()
    }
}

//    private fun monthlyChart(){
//        var scatterEntries: ArrayList<BarEntry> = ArrayList()
//        scatterChart as ScatterChart
//        scatterEntries.add(BarEntry(2f, 0))
//        scatterEntries.add(BarEntry(4f, 1))
//        scatterEntries.add(BarEntry(6f, 1))
//        scatterEntries.add(BarEntry(8f, 3))
//        scatterEntries.add(BarEntry(7f, 4))
//        scatterEntries.add(BarEntry(3f, 3))
//        var scatterDataSet = ScatterDataSet(scatterEntries as List<Entry>?, "cells")
//        var scatterData: ScatterDataSet = scatterDataSet
////        scatterChart.data = scatterData
//
//    }
//
//    private fun initChart(){
//
//        barchart as BarChart
//        val entries: ArrayList<BarEntry> = ArrayList()
//        entries.add(BarEntry(8f, 0))
//        entries.add(BarEntry(2f, 1))
//        entries.add(BarEntry(5f, 2))
//        entries.add(BarEntry(20f, 3))
//        entries.add(BarEntry(15f, 4))
//        entries.add(BarEntry(19f, 5))
//        entries.add(BarEntry(20f, 6))
//
//        val barDataSet = BarDataSet(entries, "Cells")
//
//        val labels = ArrayList<String>()
//
//        labels.add("21 \nM")
//        labels.add("22 \nT")
//        labels.add("23 \nW")
//        labels.add("24 \nT")
//        labels.add("25 \nF")
//        labels.add("26 \nS")
//        labels.add("27 \nS")
//
//        val data = BarData(labels, barDataSet)
//        barchart.data = data
//
//    }
