package com.acexams.aceexam.questiobank.modal

data class SubjectListModal(
    val `data`: ArrayList<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val created_at: String,
        val description: String,
        val id: Int,
        val paid: Int,
        val status: Int,
        val teacher_id: Int,
        val title: String,
        val updated_at: String
    )
}