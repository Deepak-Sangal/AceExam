package com.acexams.aceexam.activity.modal

data class AllperalResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val created_at: String,
        val description: String,
        val id: Int,
        val paid: Int,
        val pearls: List<Pearl>,
        val status: Int,
        val teacher_id: Int,
        val title: String,
        val updated_at: String
    ) {
        data class Pearl(
            val course_id: Int,
            val bookmark:Int,
            val created_at: String,
            val description: String,
            val id: Int,
            val title: String,
            val updated_at: String
        )
    }
}