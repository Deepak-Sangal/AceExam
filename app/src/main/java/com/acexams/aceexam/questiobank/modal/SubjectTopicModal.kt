package com.acexams.aceexam.questiobank.modal

data class SubjectTopicModal(
    val `data`: ArrayList<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val course_id: Int,
        val created_at: String,
        val id: Int,
        val level_description: String,
        val level_name: String,
        val post_quiz_id: Int,
        val pre_quiz_id: Int,
        val updated_at: String
    )
}