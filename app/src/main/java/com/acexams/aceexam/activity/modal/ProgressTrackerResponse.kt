package com.acexams.aceexam.activity.modal

data class ProgressTrackerResponse(
    val `data`: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val monthlyPercentage: String,
        val weeklyPercentage: String
    )
}