package com.example.askapp.Classes

data class Question(val question: String) {

    var answers: MutableList<String> = arrayListOf()
}