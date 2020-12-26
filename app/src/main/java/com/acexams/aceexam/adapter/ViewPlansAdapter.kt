package com.acexams.aceexam.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acexams.aceexam.R
import com.acexams.aceexam.activity.PlandeatilsActivity
import com.acexams.aceexam.activity.modal.PlanResponse
import kotlinx.android.synthetic.main.view_plans.view.*

class ViewPlansAdapter(var context:Context,var planList:List<PlanResponse.Data>):RecyclerView.Adapter<ViewPlansAdapter.Classessholder>() {
    lateinit var token:String
    inner class Classessholder (itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.viewplan.setOnClickListener{
                var intent=Intent(context,PlandeatilsActivity::class.java)
                intent.putExtra("data",planList[adapterPosition])
                context.startActivity(intent)
            }
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPlansAdapter.Classessholder {
        return Classessholder(LayoutInflater.from(context).inflate(R.layout.view_plans, parent, false))
    }



    override fun getItemCount(): Int {
        return planList.size
    }

    override fun onBindViewHolder(holder: Classessholder, position: Int) {
holder.itemView.planname.text=planList[position].name
holder.itemView.plana.text=planList[position].title
holder.itemView.des.text=planList[position].description
//        if(planList[position].plan[0].amount<planList[position].plan[1].amount){
        if(planList[position].plan!=null) {
            holder.itemView.actualprice.text = planList[position].plan[0].amount.toString()
        }
//        }else{
//            holder.itemView.actualprice.text=planList[position].plan[1].amount.toString()
//        }

    }


}