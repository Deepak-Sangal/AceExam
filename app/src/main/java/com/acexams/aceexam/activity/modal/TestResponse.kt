package com.acexams.aceexam.activity.modal

data class TestResponse(
    val `data`: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val questions: List<X0>,
        val test: List<Test>
    ) {
        data class X0(
            val created_at: String,
            val id: Int,
            val que_id: Int,
            val questionData: QuestionData,
            val test_id: Int,
            val updated_at: String
        ) {
            data class QuestionData(
                val answerKeys: List<AnswerKey>,
                val question: List<Question>
            ) {
                data class AnswerKey(
                    val created_at: String,
                    val id: Int,
                    val is_correct: Int,
                    val options: String,
                    val question_id: Int,
                    val updated_at: String
                )

                data class Question(
                    val created_at: String,
                    val id: Int,
                    val lang: String,
                    val question: String,
                    val status: Int,
                    val updated_at: String
                )
            }
        }

        data class X1(
            val created_at: String,
            val id: Int,
            val que_id: Int,
            val questionData: QuestionData,
            val test_id: Int,
            val updated_at: String
        ) {
            data class QuestionData(
                val answerKeys: List<AnswerKey>,
                val question: List<Question>
            ) {
                data class AnswerKey(
                    val created_at: String,
                    val id: Int,
                    val is_correct: Int,
                    val options: String,
                    val question_id: Int,
                    val updated_at: String
                )

                data class Question(
                    val created_at: String,
                    val id: Int,
                    val lang: String,
                    val question: String,
                    val status: Int,
                    val updated_at: String
                )
            }
        }

        data class Test(
            val created_at: String,
            val duration: Int,
            val id: Int,
            val instuction: Any,
            val status: Int,
            val title: String,
            val updated_at: String
        )
    }
}