package com.acexams.aceexam.activity.modal

data class examoftheday(
    val `data`: List<Data>,
    val message: String,
    val status: Int
) {
    data class Data(
        val created_at: String,
        val duration: Int,
        val id: Int,
        val no_question_count: Int,
        val test_given_count: Int,
        val instuction: String,
        val is_featured: Int,
        val status: Int,
        val subject_id: Any,
        val title: String,
        val type: Any,
        val updated_at: String
    )
}