package com.acexams.aceexam.progresstracker.modal

data class ProgressBarModal(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val date_of_completion: String,
        val topic_completed: Int
    )
}