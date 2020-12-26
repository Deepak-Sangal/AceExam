package com.acexams.aceexam.activity.modal

data class VideoResponse(
    val `data`:List<Data>,
    val message: String,
    val path: String,
    val pathThumbnail: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val avgRating: String,
        val completed: Int,
        val course_id: Int,
        val created_at: String,
        val description: String,
        val id: Int,
        val is_featured: Int,
        val level_id: Int,
        val name: String,
        val paid: Int,
        val search_words: String,
        val status: Int,
        val thumbnail: String,
        val title: String,
        val updated_at: String,
        val videobookmark: List<Any>
    )
}