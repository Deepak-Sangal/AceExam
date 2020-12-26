package com.acexams.aceexam.questiobank.modal

data class ReviewDetailModal(
    val `data`: List<Data>,
    val status: Int
) {
    data class Data(
        val ans: Int,
        val answerdetail: Answerdetail,
        val created_at: String,
        val id: Int,
        val question: Int,
        val questiondetail: Questiondetail,
        val status: Int,
        val test_id: Int,
        val updated_at: Any,
        val user_id: Int
    ) {
        data class Answerdetail(
            val created_at: String,
            val id: Int,
            val is_correct: Int,
            val options: String,
            val question_id: Int,
            val updated_at: String
        )

        data class Questiondetail(
            val correctanswer: Correctanswer,
            val created_at: String,
            val explaination: String,
            val id: Int,
            val lang: String,
            val question: String,
            val status: Int,
            val subject_id: Any,
            val updated_at: String
        ) {
            data class Correctanswer(
                val created_at: String,
                val id: Int,
                val is_correct: Int,
                val options: String,
                val question_id: Int,
                val updated_at: String
            )
        }
    }
}