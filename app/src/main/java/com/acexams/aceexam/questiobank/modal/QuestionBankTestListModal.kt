package com.acexams.aceexam.questiobank.modal

data class QuestionBankTestListModal(
    val `data`: Data,
    val status: Int
) {
    data class Data(
        val created_at: String,
        val id: Int,
        val no_question: Int,
        val no_question_count: Int,
        val questionlist: List<Questionlist>,
        val student_list: List<Any>,
        val updated_at: String,
        val user_id: Int
    ) {
        data class Questionlist(
            val created_at: String,
            val id: Int,
            val que_id: Int,
            val questionset: List<Questionset>,
            val test_id: Int,
            val updated_at: String
        ) {
            data class Questionset(
                val answers: List<Answer>,
                val created_at: String,
                val explaination: String,
                val id: Int,
                val lang: String,
                val question: String,
                val status: Int,
                val subject_id: Int,
                val topic: Int,
                val updated_at: String
            ) {
                data class Answer(
                    val id: Int,
                    val options: String,
                    val question_id: Int
                )
            }
        }
    }
}