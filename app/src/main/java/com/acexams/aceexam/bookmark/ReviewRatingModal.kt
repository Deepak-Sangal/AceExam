package com.acexams.aceexam.bookmark

data class ReviewRatingModal(
    val `data`: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val rating: String,
        val review: String,
        val video_id: String
    )
}