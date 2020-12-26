package com.acexams.aceexam.activity.modal

data class CourseResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val chapterCount:Int,
        val bookmarkCount:Int,
        val created_at: String,
        val description: String,
        val id: Int,
        val status: Int,
        val teacher_id: Int,
        val title: String,
        val updated_at: String
    )
}