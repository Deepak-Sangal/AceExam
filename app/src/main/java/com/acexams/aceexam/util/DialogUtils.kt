package com.acexams.aceexam.util

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.acexams.aceexam.R


class DialogUtils {

    companion object {

        var mAlertDialog: Dialog? = null

        fun showProgressLoadingBar(context: Context?) {

            val layoutInflater = LayoutInflater.from(context)
            val dialogView = layoutInflater.inflate(R.layout.progress_dialog, null)
            val alertDialogBuilder = AlertDialog.Builder(context, R.style.MyDialogTheme)
            alertDialogBuilder.setView(dialogView)

            mAlertDialog = alertDialogBuilder.create()

            mAlertDialog!!.show()
            mAlertDialog!!.window!!.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            )
            mAlertDialog!!.window!!.setGravity(Gravity.CENTER_HORIZONTAL)
            mAlertDialog!!.window!!.setBackgroundDrawableResource(R.color.transparent)
            mAlertDialog!!.setCanceledOnTouchOutside(false)

        }


        fun dismissProgressLoadingBar() {
            mAlertDialog?.dismiss()
        }


    }
}