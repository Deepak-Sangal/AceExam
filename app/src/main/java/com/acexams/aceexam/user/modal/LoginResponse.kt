package com.acexams.aceexam.user.modal

data class LoginResponse(
    val `data`: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val id: Int,
        val name: String,
        val token: String
    )
}