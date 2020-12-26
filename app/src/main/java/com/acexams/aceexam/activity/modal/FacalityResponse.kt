package com.acexams.aceexam.activity.modal

data class FacalityResponse(
    val `data`: List<Data>,
    val message: String,
    val path: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val created_at: String,
        val email: String,
        val email_verified_at: Any,
        val id: Int,
        val mobile: String,
        val name: String,
        val role: Int,
        val status: Int,
        val teacherdetail: Teacherdetail,
        val temp_otp: Any,
        val updated_at: String
    ) {
        data class Teacherdetail(
            val address: String,
            val created_at: String,
            val department: String,
            val experience: Int,
            val gender: String,
            val id: Int,
            val institute: String,
            val logo: Any,
            val qualification: String,
            val subject_id: Int,
            val description: String,
            val updated_at: String,
            val user_id: Int
        )
    }
}