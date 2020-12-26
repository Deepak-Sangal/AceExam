package com.app.politciannewapp.utils

import android.app.ProgressDialog
import android.content.Context

class MyProgressDialog {

    companion object {

        private var progress: ProgressDialog? = null

        fun showProgress(context: Context) {
            progress = ProgressDialog(context)
            progress!!.setMessage("Please Wait")
            progress!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progress!!.isIndeterminate = true
            progress!!.setCancelable(false)
            progress!!.show()

        }

        fun showProgressforimport(context: Context, total: String, current: String) {

            progress = ProgressDialog(context)
            progress!!.setMessage("Export" + current + "/" + total)
            progress!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progress!!.isIndeterminate = true
            progress!!.setCancelable(false)
            progress!!.show()

        }

        fun setMsg(msg: String) {

            progress!!.setMessage(msg)
        }

        fun dismissProgress() {
            if (progress != null && progress!!.isShowing)
                progress!!.dismiss()
        }

    }

}
