package com.acexams.aceexam.faq.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.acexams.aceexam.R

class FaqsGridAdapter(
    val context: Context,
    var faqsName: Array<String>,
    var playerImages: IntArray,
    val expend: Int
) : BaseAdapter() {

    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    override fun getCount(): Int {
        return if(expend==0) 4 else 7
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var layoutInflater : LayoutInflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var convertView = convertView
        convertView = layoutInflater!!.inflate(R.layout.adapter_faqs_grid,null)
        textView = convertView.findViewById(R.id.faqs_grid_textView)
        imageView = convertView.findViewById(R.id.faqs_grid_imageView)
        textView.text = faqsName[position]
        imageView.setImageResource(playerImages[position])
        return convertView
    }

}