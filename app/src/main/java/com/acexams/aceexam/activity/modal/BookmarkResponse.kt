package com.acexams.aceexam.activity.modal

data class BookmarkResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val created_at: String,
        val duration: String,
        val id: Int,
        val title: String,
        val updated_at: Any,
        val videoid: Int
    )
}