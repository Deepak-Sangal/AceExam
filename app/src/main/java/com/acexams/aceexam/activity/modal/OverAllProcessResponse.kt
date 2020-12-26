package com.acexams.aceexam.activity.modal

data class OverAllProcessResponse(
    val `data`: ArrayList<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val percent: Int,
        val subject_id: Int,
        val subject_name: String,
        val test_id: Int
    )
}