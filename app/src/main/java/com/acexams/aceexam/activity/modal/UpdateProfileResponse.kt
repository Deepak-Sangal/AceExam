package com.acexams.aceexam.Model

data class UpdateProfileResponse(
    val message: String,
    val success: Boolean,
    val staus:Int,
    val error:String,
    val data:String
)