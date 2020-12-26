package com.acexams.aceexam.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.acexams.aceexam.retrofit.ApiInterface
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.PlanResponse
import com.paytm.pgsdk.*
import com.talkingtb.talkingtb.remote.ApiClien
import kotlinx.android.synthetic.main.activity_plandeatils.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class PlandeatilsActivity : AppCompatActivity() {
    lateinit var data:PlanResponse.Data
    var checksum:String=""
    var orderid:String=""

    var TAG="Main Activity"
    lateinit var amount:String
    var midString="Teqtis50366959612907"
    var txnAmountString="200"
    var OrderIdString=""
    var txnTokenString=""
    private val ActivityRequestCode = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plandeatils)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        var c= Calendar.getInstance()
        var df= SimpleDateFormat("ddMMyyyy")
        var date=df.format(c.time)
        var random=Random()
        var min=1000
        var max=9999

        var randomNo=random.nextInt(
            (max - min) + 1
        )+min

        OrderIdString=date+randomNo

        if(intent.extras!=null){
            data=intent.getSerializableExtra("data") as PlanResponse.Data
        }
        radioone.isChecked=true
     //   checksumgenrate()
        setdata()
        secondplan.setOnClickListener{
            radiotwo.isChecked=true
            month.text="18 month"
            radioone.isChecked=false
            totalprice.text=data.plan[1].amount.toString()
        }
        planfirst.setOnClickListener{
            radiotwo.isChecked=false
            month.text="12 month"
            radioone.isChecked=true
            totalprice.text=data.plan[0].amount.toString()
        }
        radiotwo.setOnClickListener{
            radiotwo.isChecked=true
            month.text="18 month"
            radioone.isChecked=false
            totalprice.text=data.plan[1].amount.toString()
        }
        radioone.setOnClickListener{
            radiotwo.isChecked=false
            month.text="12 month"
            radioone.isChecked=true
            totalprice.text=data.plan[0].amount.toString()
        }
        backv.setOnClickListener {
            onBackPressed()
        }
        tv_buy_now.setOnClickListener{
            getToken()
        }
    }

/*    private fun buynow() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS),
                101
            )
        }

        val Service = PaytmPGService.getStagingService()
        val paramMap: HashMap<String, String> = HashMap()
        paramMap.put("MID", "Teqtis50366959612907");
// Key in your staging and production MID available in your dashboard
        paramMap.put("ORDER_ID", "ARCVG");
        paramMap.put("CUST_ID", "AEDCGV");
        paramMap.put("MOBILE_NO", "8865837389");
        paramMap.put("EMAIL", "chetangupta501@gmail.com");
        paramMap.put("CHANNEL_ID", "WAP");
        paramMap.put("TXN_AMOUNT", "1");
        paramMap.put("WEBSITE", "WEBSTAGING");
// This is the staging value. Production value is available in your dashboard
        paramMap.put("INDUSTRY_TYPE_ID", "Retail");
// This is the staging value. Production value is available in your dashboard
        paramMap.put(
            "CALLBACK_URL",
            "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=" +"ARCVG"
        );
        paramMap.put(
            "CHECKSUMHASH",
            checksum
        )
        val Order = PaytmOrder(paramMap)
        Service.initialize(Order, null);
        Service.startPaymentTransaction(this, true, true, object : PaytmPaymentTransactionCallback {
            override fun someUIErrorOccurred(inErrorMessage: String) {}
            override fun onTransactionResponse(inResponse: Bundle) {}
            override fun networkNotAvailable() {}
            override fun clientAuthenticationFailed(inErrorMessage: String) {}
            override fun onErrorLoadingWebPage(
                iniErrorCode: Int,
                inErrorMessage: String,
                inFailingUrl: String
            ) {
            }

            override fun onBackPressedCancelTransaction() {}
            override fun onTransactionCancel(inErrorMessage: String, inResponse: Bundle) {}
        })
    }*/

    private fun setdata() {
        if(data.plan!=null) {
            firstrs.text = data.plan[0].amount.toString()
            secondrs.text = data.plan[1].amount.toString()
            totalprice.text = data.plan[0].amount.toString()

            name.text = data.title
            descriooooo.text = data.description
            titleqwe.text = data.name
        }


    }
  /*  private fun checksumgenrate() {
        MyProgressDialog.showProgress(this)
        val apiService = ApiClien.getClient().create(ApiInterface::class.java)
        val hashMap: HashMap<String, String> = HashMap()
        hashMap.put("MID", "Teqtis50366959612907")
        hashMap.put("ORDER_ID", "ARCVG")
        hashMap.put("CUST_ID", "AEDCGV");
        hashMap.put("INDUSTRY_TYPE_ID", "Retail");
        hashMap.put("CHANNEL_ID", "WAP");
        hashMap.put("TXN_AMOUNT", "1");
        hashMap.put("WEBSITE", "WEBSTAGING");
        hashMap.put("CALLBACK_URL", "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=" + "ARCVG");

        val call = apiService.paytmchecksum(
            hashMap
        )
        call.enqueue(object : Callback<PaytmResponse> {


            override fun onResponse(call: Call<PaytmResponse>, response: Response<PaytmResponse>) {
                MyProgressDialog.dismissProgress()
                if (response.code() == 200) {
                    checksum=response.body()!!.CHECKSUMHASH
//                    orderid=response.body()!!.ORDER_ID

                }

            }

            override fun onFailure(call: Call<PaytmResponse>, t: Throwable) {
                MyProgressDialog.dismissProgress()
                AppUtils.showToast(this@PlandeatilsActivity, t.toString())
            }
        })
    }*/


    fun getToken() {
        val apiService = ApiClien.getClient().create(ApiInterface::class.java)
        val registerCall: Call<ResponseBody> = apiService.getcheckSum(
            "Teqtis50366959612907",
            OrderIdString.toString(),
            "ABC_123",
            "8920050565",
            "nidhi@gmail.com",
            "WAP",
            "DEFAULT",
            txnAmountString,
            "Retail",
            //  "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=" + OrderIdString
        )
        registerCall?.enqueue(object : Callback<ResponseBody> {


            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                var obj = response.body()?.string()
                Log.e("res", obj.toString())
                var json= JSONObject(obj)
                var status=json.getString("CHECKSUMHASH")
                Log.e("paytmen",status)
                startPaytmPayment(status)


            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("error", t.toString())
            }

        })

    }


    fun startPaytmPayment(token: String) {
        txnTokenString = token
        // for test mode use it
        // "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=" + OrderIdString
        //val host = "https://securegw-stage.paytm.in/"
        // for production mode use it
        val host = "https://securegw.paytm.in/"
        val orderDetails =
            ("MID: " + midString + ", OrderId: " + OrderIdString + ", TxnToken: " + txnTokenString
                    + ", Amount: " + txnAmountString)
        //Log.e(TAG, "order details "+ orderDetails);
        val callBackUrl = host + "theia/paytmCallback?ORDER_ID=" + OrderIdString
        Log.e(TAG, " callback URL $callBackUrl")
        val paytmOrder =
            PaytmOrder(OrderIdString, midString, txnTokenString, txnAmountString, callBackUrl)
        val transactionManager =
            TransactionManager(paytmOrder, object : PaytmPaymentTransactionCallback {
                override fun onTransactionResponse(bundle: Bundle) {
                    Log.e(TAG, "Response (onTransactionResponse) : $bundle")
                }

                override fun networkNotAvailable() {
                    Log.e(TAG, "network not available ")
                }

                override fun onErrorProceed(s: String) {
                    Log.e(TAG, " onErrorProcess $s")
                }

                override fun clientAuthenticationFailed(s: String) {
                    Log.e(TAG, "Clientauth $s")
                }

                override fun someUIErrorOccurred(s: String) {
                    Log.e(TAG, " UI error $s")
                }

                override fun onErrorLoadingWebPage(i: Int, s: String, s1: String) {
                    Log.e(TAG, " error loading web $s--$s1")
                }

                override fun onBackPressedCancelTransaction() {
                    Log.e(TAG, "backPress ")
                }

                override fun onTransactionCancel(s: String, bundle: Bundle) {
                    Log.e(TAG, " transaction cancel $s")
                }
            })
        transactionManager.setShowPaymentUrl(host + "theia/api/v1/showPaymentPage")
        transactionManager.startTransaction(this, ActivityRequestCode)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.e(TAG, " result code $resultCode")
        // -1 means successful  // 0 means failed
        // one error is - nativeSdkForMerchantMessage : networkError
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ActivityRequestCode && data != null) {
            val bundle = data.extras
            if (bundle != null) {
                for (key in bundle.keySet()) {
                    Log.e(TAG, key + " : " + if (bundle[key] != null) bundle[key] else "NULL")
                }
            }
            Log.e(TAG, " data " + data.getStringExtra("nativeSdkForMerchantMessage"))
            Log.e(TAG, " data response - " + data.getStringExtra("response"))
            /*
 data response - {"BANKNAME":"WALLET","BANKTXNID":"1394221115",
 "CHECKSUMHASH":"7jRCFIk6eRmrep+IhnmQrlrL43KSCSXrmM+VHP5pH0ekXaaxjt3MEgd1N9mLtWyu4VwpWexHOILCTAhybOo5EVDmAEV33rg2VAS/p0PXdk\u003d",
 "CURRENCY":"INR","GATEWAYNAME":"WALLET","MID":"EAcP3138556","ORDERID":"100620202152",
 "PAYMENTMODE":"PPI","RESPCODE":"01","RESPMSG":"Txn Success","STATUS":"TXN_SUCCESS",
 "TXNAMOUNT":"2.00","TXNDATE":"2020-06-10 16:57:45.0","TXNID":"2020061011121280011018328631290118"}
  */Toast.makeText(
                this, data.getStringExtra("nativeSdkForMerchantMessage")
                        + data.getStringExtra("response"), Toast.LENGTH_SHORT
            ).show()
        } else {
            Log.e(TAG, " payment failed")
        }
    }


}