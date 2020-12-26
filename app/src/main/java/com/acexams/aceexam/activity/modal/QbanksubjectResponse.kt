package com.acexams.aceexam.activity.modal

import java.io.Serializable

data class QbanksubjectResponse(
    val `data`: ArrayList<Data>,
    val message: String,
    val status: Int,
    val success: String
) :Serializable{
    data class Data(
        val chapter: ArrayList<Chapter>,
        val created_at: String,
        val description: String,
        val id: Int,
        val paid: Int,
        val status: Int,
        val teacher_id: Int,
        val title: String,
        val updated_at: String
    ) :Serializable{
        data class Chapter(
            val course_id: Int,
            val created_at: String,
            val id: Int,
           val topic_count:String,
            val level_description: String,
            val level_name: String,
            val post_quiz_id: Int,
            val pre_quiz_id: Int,
            val topic: ArrayList<Topic>,
            val updated_at: String
        ):Serializable {
            data class Topic(
                val course_id: Int,
                val created_at: String,
                val description: String,
                val count:String,
                val id: Int,
                val name: String,
                val question: List<Question>,
                val subject_id: Int,
                val updated_at: String
            ):Serializable {
                data class Question(
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
                ):Serializable
            }
        }
    }
}