package com.acexams.aceexam.activity.modal

data class SearchResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int
) {
    data class Data(
        val course_id: Int,
        val created_at: String,
        val keyname:String,
        val description: String,
        val id: Int,
        val image: Any,
        val name: String,
        val question_count: Int,
        val seachtype: String,
        val subject_id: Int,
        val updated_at: String
    )
}