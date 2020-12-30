package com.acexams.aceexam.activity.modal

data class VideoListResponse(
    val `data`: List<Data>,
    val message: String,
    val path: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val course_id: Int,
        val created_at: String,
        val description: String,
        val id: Int,
        val completed:Int,
        val avgRating:Float,
        val paid:Int,
        val status_videoBookmarked:Int,
        val level_id: Int,
        val thumbnail:String,
        val name: String,
        val search_words: String,
        val status: Int,
        val title: String,
        val updated_at: String
    )
}