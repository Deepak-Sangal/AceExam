package com.acexams.aceexam.contactus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.acexams.aceexam.R
import kotlinx.android.synthetic.main.adapter_spinner_text.view.*

class SpinnerAdapter(var context: Context,
                    var detail : Array<String>)
    : BaseAdapter() {


    val layoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return detail.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val myView = layoutInflater.inflate(R.layout.adapter_spinner_text,parent,false)
        convertView!!.contact_text_spinner.text = detail[position]
        return myView
    }
}