package com.example.askapp.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.askapp.R

class QuestionsFragment : Fragment() {

    private lateinit var notificationsViewModel: QuestionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(QuestionsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_questions, container, false)

        return root
    }
}