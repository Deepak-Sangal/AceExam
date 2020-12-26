package com.acexams.aceexam.activity.modal

import java.io.Serializable

data class PlanResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
):Serializable {
    data class Data(
        val created_at: String,
        val description: String,
        val id: Int,
        val name: String,
        val plan: List<Plan>,
        val title: String,
        val updated_at: Any
    ) :Serializable{
        data class Plan(
            val amount: String,
            val created_at: String,
            val id: Int,
            val months: String,
            val subscription_id: Int,
            val updated_at: Any
        ):Serializable
    }
}