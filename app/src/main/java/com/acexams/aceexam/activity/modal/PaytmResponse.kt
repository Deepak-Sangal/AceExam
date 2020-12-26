package com.acexams.aceexam.activity.modal

data class PaytmResponse(
    val CHECKSUMHASH: String,
    val ORDER_ID: String,
    val payt_STATUS: String
)