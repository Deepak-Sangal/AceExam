package com.acexams.aceexam.Model

data class GetProfileResponse(
    val `data`: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val email: String,
        val id: Int,
        val mobile: String,
        val name: String,
        val image :String,
        val year:String,
        val exam_name:String,
        val collegeName:String
    )
}