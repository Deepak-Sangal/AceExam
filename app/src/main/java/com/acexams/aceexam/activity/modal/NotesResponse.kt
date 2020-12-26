package com.acexams.aceexam.activity.modal

data class NotesResponse(
    val `data`: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val notesData: List<NotesData>,
        val notes_path: String
    ) {
        data class NotesData(
            val course_id: Int,
            val created_at: String,
            val id: Int,
            val level_id: Int,
            val note_file_name: String,
            val updated_at: String,
            val video_id: Int
        )
    }
}