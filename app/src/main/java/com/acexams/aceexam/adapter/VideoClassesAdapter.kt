package com.acexams.aceexam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.modal.BookmarkResponse
import kotlinx.android.synthetic.main.adpter_videoclasses.view.*
import java.text.NumberFormat

class VideoClassesAdapter(
    var context: Context,
    var book: List<BookmarkResponse.Data>,
    var videopalyer: VideoView
):RecyclerView.Adapter<VideoClassesAdapter.VideoClassesaHolder>() {
   inner class VideoClassesaHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.bookmark.setOnClickListener{
                val currentPosition: Int = videopalyer.getCurrentPosition()
                videopalyer.seekTo(((book[adapterPosition].duration.toFloat() * 1000).toInt()))
                videopalyer.start()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoClassesAdapter.VideoClassesaHolder {
        return VideoClassesaHolder(
            LayoutInflater.from(context).inflate(R.layout.adpter_videoclasses, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoClassesAdapter.VideoClassesaHolder, position: Int) {
        val separated: Array<String> = book[position].duration.split(".").toTypedArray()
//        var milisecond=((separated[0].toInt()*1000) + separated[1]).toInt()
        var value=(book[position].duration.toFloat() *0.0166667)
        val formatter: NumberFormat = NumberFormat.getNumberInstance()
        formatter.setMinimumFractionDigits(2)
        formatter.setMaximumFractionDigits(2)
        val number: String = formatter.format(value)
        holder.itemView.time.text=separated[0].toString() + " sec"
        holder.itemView.titlename.text=book[position].title
    }

    override fun getItemCount(): Int {
        return book.size
    }
}