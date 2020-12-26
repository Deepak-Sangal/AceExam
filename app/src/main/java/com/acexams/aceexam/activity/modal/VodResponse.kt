package com.example.aceexam.activity.modal

data class VodResponse(
    val `data`: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val base_path: String,
        val videos: List<Video>
    ) {
        data class Video(
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
            val updated_at: String
        )
    }
}