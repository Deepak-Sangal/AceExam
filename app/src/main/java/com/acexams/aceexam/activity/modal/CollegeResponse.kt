package com.acexams.aceexam.activity.modal

data class CollegeResponse(
    val `data`: List<Data>,
    val message: String,
    val success: Boolean
) {
    data class Data(
        val created_at: String,
        val id: Int,
        val logo: String,
        val name: String,
        val state_id: Int,
        val updated_at: Any
    )
}