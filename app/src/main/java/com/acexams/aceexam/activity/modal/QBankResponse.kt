package com.acexams.aceexam.activity.modal

import java.io.Serializable

data class QBankResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: String
):Serializable {
    data class Data(
        val created_at: String,
        val description: String,
        val id: Int,
        val paid: Int,
        val status: Int,
        val teacher_id: Int,
        val title: String,
        val topic: ArrayList<Topic>,
        val updated_at: String
    ):Serializable  {
        data class Topic(
            val course_id: Int,
            val created_at: String,
            val examtopic: ArrayList<Examtopic>,
            val id: Int,
            val level_description: String,
            val level_name: String,
            val post_quiz_id: Int,
            val pre_quiz_id: Int,
            val updated_at: String,
            val topic_chapter_count: String,
        ):Serializable  {
            data class Examtopic(
                val created_at: String,
                val explaination: String,
                val id: Int,
                val lang: String,
                val question: String,
                val status: Int,
                val subject_id: Int,
                val topic: Int,
                val topic_id: Int,
                val updated_at: String
            ):Serializable
        }
    }
}