package com.acexams.aceexam

data class weew(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val created_at: String,
        val description: String,
        val id: Int,
        val name: String,
        val plan: List<Plan>,
        val title: String,
        val updated_at: Any
    ) {
        data class Plan(
            val amount: String,
            val created_at: String,
            val id: Int,
            val months: Int,
            val subscription_id: Int,
            val updated_at: Any
        )
    }
}