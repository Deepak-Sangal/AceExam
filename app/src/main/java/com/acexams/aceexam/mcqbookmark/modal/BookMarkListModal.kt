package com.acexams.aceexam.mcqbookmark.modal

import java.io.Serializable

data class BookMarkListModal(
    val `data`: ArrayList<Data>,
    val message: String,
    val status: Int
):Serializable {
    data class Data(
        val created_at: String,
        val description: String,
        val id: Int,
        val image: Any,
        val no_question: Int,
        val paid: Int,
        val questionbookmark: ArrayList<Questionbookmark>,
        val status: Int,
        val teacher_id: Int,
        val title: String,
        val updated_at: String
    ) :Serializable {
        data class Questionbookmark(
            val created_at: String,
            val id: Int,
            val question: Question,
            val question_id: Int,
            val subject_id: Int,
            val updated_at: String,
            val user_id: Int
        ) :Serializable {
            data class Question(
                val answers: ArrayList<Answer>,
                val chapter_id: Int,
                val created_at: String,
                val explaination: String,
                val id: Int,
                val lang: String,
                val question: String,
                val status: Int,
                val subject_id: Int,
                val topic_id: Int,
                val updated_at: String
            ):Serializable  {
                data class Answer(
                    val created_at: String,
                    val id: Int,
                    val is_correct: Int,
                    val options: String,
                    val question_id: Int,
                    val updated_at: String
                ):Serializable
            }
        }
    }
}