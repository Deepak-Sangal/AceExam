package com.acexams.aceexam.Model

data class SignupResponse(
    val `data`: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val address: String,
        val email: String,
        val mobile: String,
        val name: String
    )
}