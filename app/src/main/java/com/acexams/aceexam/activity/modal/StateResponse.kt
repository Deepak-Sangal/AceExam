package com.acexams.aceexam.activity.modal

data class StateResponse(
    val `data`: List<Data>,
    val message: String,
    val success: Boolean
) {
    data class Data(
        val country_id: Int,
        var color:Int=0,
        val state_id: Int,
        val state_name: String
    )
}