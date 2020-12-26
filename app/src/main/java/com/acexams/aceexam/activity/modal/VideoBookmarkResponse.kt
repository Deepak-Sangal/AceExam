package com.acexams.aceexam.activity.modal

data class VideoBookmarkResponse(
    val `data`: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val status: String,
        val user_id: String,
        val video_id: String
    )
}