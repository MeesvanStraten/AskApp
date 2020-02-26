package com.example.askapp.Classes

data class Question(var question: String) {

    var answers: MutableList<String> = arrayListOf()
}