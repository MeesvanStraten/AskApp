package com.example.askapp.ui.questions

class Question(val id: Int,val answerIdentity: Array<Int>,val questionAsked: String) {
    private val questionId = id
    private val answerId = answerIdentity
    private val question: String = questionAsked


    fun getQuestion(): String {
        return question
    }

    fun getQuestionId(): Int {
        return questionId
    }

    fun getAnswersFromQuestion(): Array<Int> {
        return answerId
    }
}