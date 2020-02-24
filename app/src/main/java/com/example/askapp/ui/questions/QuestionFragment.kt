package com.example.askapp.ui.questions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.askapp.R
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore


class QuestionFragment : Fragment() {

    companion object {
        fun newInstance() = QuestionFragment()
    }

    private lateinit var viewModel: QuestionViewModel

    override fun onCreateView(

    inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.question_fragment, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnSubmitQuestion = view.findViewById<Button>(R.id.buttonSubmitQuestion)
        val questionInput = view.findViewById<EditText>(R.id.questionEditText)
        FirebaseApp.initializeApp(this.requireContext())

        val db = FirebaseFirestore.getInstance()

        btnSubmitQuestion.setOnClickListener {
            var questionData = hashMapOf(
                "question" to questionInput.text.toString()
            )

            db.collection("questions")
                .document()
                .set(questionData)
            questionInput.text.clear()
        }
    }






}
