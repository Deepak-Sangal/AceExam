package com.acexams.aceexam.user.modal

data class LoginResponseModal(
    val `data`: Data,
    val message: String,
    val status: Int,
    val error: String
)