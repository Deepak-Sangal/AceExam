package com.acexams.aceexam.activity.modal

data class TestexamResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val created_at: String,
        val duration: Int,
        val id: Int,
        val is_given:Int,
        val instuction: Any,
        val questionCount: Int,
        val questions: List<Question>,
        val status: Int,
        val title: String,
        val updated_at: String
    ) {
        data class Question(
            val created_at: String,
            val id: Int,
            val que_id: Int,
            val test_id: Int,
            val updated_at: String
        )
    }
}