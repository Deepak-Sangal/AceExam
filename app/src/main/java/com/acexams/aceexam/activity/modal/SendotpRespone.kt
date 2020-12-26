package com.acexams.aceexam.activity.modal

data class SendotpRespone(
    val `data`: List<Any>,
    val error: String,
    val message: String,
    val status: Int
)