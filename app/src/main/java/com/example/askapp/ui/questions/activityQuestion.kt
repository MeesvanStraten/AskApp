package com.example.askapp.ui.questions

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.askapp.R
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_question.*


class activityQuestion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        setSupportActionBar(toolbar)

        FirebaseApp.initializeApp(this)
         var db = FirebaseFirestore.getInstance()
         var submitBtn = findViewById<Button>(R.id.buttonSubmit)
         var questionInput = findViewById<EditText>(R.id.questionEditText)

         var question:String? ="Test"

        submitBtn.setOnClickListener{
            question = questionInput.text.toString()
            Toast.makeText(this,question,Toast.LENGTH_SHORT).show()

            var testquestion = hashMapOf(
                "question" to question
            )

            db.collection("questions").document().set(testquestion)
        }
    }
}


