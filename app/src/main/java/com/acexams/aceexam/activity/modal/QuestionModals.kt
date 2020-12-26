package com.acexams.aceexam.activity.modal

data class QuestionModals(
    val `data`: Data,
    val status: Int
) {
    data class Data(
        val created_at: String,
        val duration: Int,
        val id: Int,
        val instuction: Any,
        val no_question_count: Int,
        val no_student: Int,
        val questionlist: List<Questionlist>,
        val status: Int,
        val student_list: List<Any>,
        val title: String,
        val updated_at: String
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
                val id: Int,
                val bookmark:Int,
                val lang: String,
                val question: String,
                val status: Int,
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