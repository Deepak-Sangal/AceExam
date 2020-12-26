package com.acexams.aceexam.questiobank.adpater

data class slideResponse(
    val `data`: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val slideData: List<SlideData>,
        val slides_path: String
    ) {
        data class SlideData(
            val course_id: Int,
            val created_at: String,
            val id: Int,
            val level_id: Int,
            val slide_file_name: String,
            val updated_at: String,
            val video_id: Int
        )
    }
}