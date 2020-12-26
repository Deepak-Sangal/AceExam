package com.acexams.aceexam.activity.modal

data class SubjectResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val course_id: Int,
        val created_at: String,
        val id: Int,
        val image:String,
        val level_description: String,
        val level_name: String,
        val post_quiz_id: Int,
        val pre_quiz_id: Int,
        val updated_at: String
    )
}