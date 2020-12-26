package com.acexams.aceexam.activity.modal

data class ModResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int
) {
    data class Data(
        val answers: List<Answer>,
        val created_at: String,
        val date: String,
        val explaination: String,
        val id: Int,
        val lang: String,
        val question: String,
        val updated_at: String
    ) {
        data class Answer(
            val created_at: String,
            val id: Int,
            val is_correct: Int,
            val options: String,
            val question_id: Int,
            val updated_at: String
        )
    }
}