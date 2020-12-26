package com.card.visitingcardscanner.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.Toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class AppUtils {
    val DATE_OUTPUT_FORMAT = "dd-MMM-yyyy"

    var suffixes = arrayOf(
        "th",
        "st",
        "nd",
        "rd",
        "th",
        "th",
        "th",
        "th",
        "th",
        "th",  //    10    11    12    13    14    15    16    17    18    19
        "th",
        "th",
        "th",
        "th",
        "th",
        "th",
        "th",
        "th",
        "th",
        "th",  //    20    21    22    23    24    25    26    27    28    29
        "th",
        "st",
        "nd",
        "rd",
        "th",
        "th",
        "th",
        "th",
        "th",
        "th",  //    30    31
        "th",
        "st"
    )

    companion object {

        fun showToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }

        fun showToastShort(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        fun Utctodate(date: String): String {
            val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
            val output = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
            var d: Date? = null
            try {
                d = input.parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            val formatted: String = output.format(d)
            Log.i("DATE", "" + formatted)
            return formatted
        }

        fun Utctodatewithyyyymmdd(date: String): String {
            val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
            val output = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
            var d: Date? = null
            try {
                d = input.parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            val formatted: String = output.format(d)
            Log.i("DATE", "" + formatted)
            return formatted
        }

        fun Utctodatewithyyyymmdd5(date: String): String {
            val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
            val output = SimpleDateFormat("yyyy/MM/dd")
            var d: Date? = null
            try {
                d = input.parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            val formatted: String = output.format(d)
            Log.i("DATE", "" + formatted)
            return formatted
        }



        fun Utctodatewithyyyymmdd1(date: String): String {
            val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
            val output = SimpleDateFormat("dd/MM/yyyy")
            var d: Date? = null
            try {
                d = input.parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            val formatted: String = output.format(d)
            Log.i("DATE", "" + formatted)
            return formatted
        }

        fun datetomilisecond(date: String): Long {
            var timeInMilliseconds: Long = 0
            val sdf =
                SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
            sdf.timeZone = TimeZone.getTimeZone("IST")
            try {
                val mDate = sdf.parse(date)
                timeInMilliseconds = mDate.time


            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return timeInMilliseconds
        }

        fun getDate(
            milliSeconds: Long
        ): String? { // Create a DateFormatter object for displaying date in specified format.
            val formatter = SimpleDateFormat("HH:mm")
            // Create a calendar object that will convert the date and time value in milliseconds to date.
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliSeconds
            return formatter.format(calendar.time)
        }

        fun getDate1(
            milliSeconds: Long
        ): String? { // Create a DateFormatter object for displaying date in specified format.
            val formatter = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
            // Create a calendar object that will convert the date and time value in milliseconds to date.
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliSeconds
            return formatter.format(calendar.time)
        }

//        fun milisecocndtohhmm(mili: Long): String {
//            val hms = java.lang.String.format(
//                "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(mili),
//                TimeUnit.MILLISECONDS.toMinutes(mili) - TimeUnit.HOURS.toMinutes(
//                    TimeUnit.MILLISECONDS.toHours(
//                        mili
//                    )
//                )
//            )
//            return hms
//        }

        fun getssid(context: Context): String? {
            return try {
                val wifiManager =
                    context.getSystemService(Context.WIFI_SERVICE) as WifiManager
                val wifiInfo = wifiManager.connectionInfo
                wifiInfo.ssid
            } catch (e: Exception) {
                Log.d("hello", "hello")
                null
            }
        }

//        fun getK_BASE_URL(): String? { //        return K_BASE_URL_resp;
//        return  Constants.BaseUrlNewlive;
//        }


        fun getFormattedDate(
            context: Context?,
            smsTimeInMilis: Long
        ): String? {
            val smsTime = Calendar.getInstance()
            smsTime.timeInMillis = smsTimeInMilis
            val now = Calendar.getInstance()
            val timeFormatString = "h:mm aa"
            val dateTimeFormatString = "EEEE, MMMM d, h:mm aa"
            val HOURS = 60 * 60 * 60.toLong()
            return if (now[Calendar.DATE] === smsTime[Calendar.DATE]) {
                "Today"
            } else if (now[Calendar.DATE] - smsTime[Calendar.DATE] === 1) {
                "Yesterday"
            } else return "before"
        }


//        fun checkwifiandmobiledata(): Boolean {
//            var value: Boolean = false
//            val connectivitymanager =
//                Constants.context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
//            val networkInfo = connectivitymanager!!.allNetworkInfo
//
//            for (netInfo in networkInfo) {
//                if (netInfo.typeName.equals(
//                        "WIFI",
//                        ignoreCase = true
//                    ) && netInfo.isConnected
//                ) if (netInfo.isConnected) {
//                    value = false
//                }
//                if (netInfo.typeName.equals(
//                        "MOBILE",
//                        ignoreCase = true
//                    )
//                ) if (netInfo.isConnected) {
//                    value = true
//                }
//            }
//            return value
//        }


//        fun isNetworkConnected(context: Context?): Boolean {
//            if (context != null) {
//                val cm =
//                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//                if (cm != null) {
//                    val activeNetwork = cm.activeNetworkInfo
//                    return activeNetwork != null && activeNetwork.isConnectedOrConnecting
//                }
//            }
//            return false
//        }

//         fun opendialogforsessionexpire(context: Context,acivtity: HomeActivity) {
//            var dialog = Dialog(context)
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            dialog.setContentView(R.layout.unauthorizeddialoglayout);
//            dialog.setCancelable(false)
//            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
//            dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            dialog.findViewById<TextView>(R.id.sessionexpire).setOnClickListener {
//                context.startActivity(Intent(context!!, LoginAcivtity::class.java))
//                acivtity.finish()
//            }
//            dialog.show()
//        }


    }
}