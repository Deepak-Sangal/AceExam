package com.acexams.aceexam.questiobank.modal

data class QuestiontestResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: String
) {
    data class Data(
        val answers: List<Answer>,
        val created_at: String,
        val explaination: String,
        val id: Int,
        var bookmark:Int,
        val lang: String,
        val right_percenatge:String,
        val question: String,
        val status: Int,
        val subject_id: Int,
        val topic: Int,
        val topic_chapter: String,
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