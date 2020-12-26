package com.example.paytm

data class RankingResponseModal(
    val `data`: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val base_path: String,
        val detial: List<Detial>
    ) {
        data class Detial(
            val correct: Int,
            val created_at: String,
            val id: Int,
            val in_correct: Int,
            val logo: String,
            val name: String,
            val percentage: Int,
            val skipped: Int,
            val test_id: Int,
            val type: Int,
            val updated_at: Any,
            val user_id: Int
        )
    }
}