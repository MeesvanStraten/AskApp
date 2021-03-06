package com.example.askapp.Classes

data class Question(var question:String? = ""){

    var answers: MutableList<String> = arrayListOf()

    fun toMap(): Map<String, Any?> {
        return mapOf(
            "question" to question,
            "answers" to answers
        )
    }
}

