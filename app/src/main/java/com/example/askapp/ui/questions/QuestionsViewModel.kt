package com.example.askapp.ui.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
    }
    var questionList = mutableListOf<Question>()


    fun addQuestion(question: Question){
        questionList.add(question)
    }
}