package com.acexams.aceexam.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.activity_pdf_reader.*


class PdfReaderActivity : AppCompatActivity() {

var pdf:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_reader)
       // progressBar.visibility=View.VISIBLE

        pdf_view.getSettings().setJavaScriptEnabled(true)
        pdf_view.getSettings().setBuiltInZoomControls(true)
        pdf= intent.getStringExtra("pdf")!!


     /*   pdf_view.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                supportActionBar!!.title = "Loading........"
                if (newProgress == 100) {
                    progressBar.visibility = View.GONE

                }
            }
        }*/

//        val pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf"
        pdf_view.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=$pdf")
        // pdf_view.loadUrl(url);
    }
}