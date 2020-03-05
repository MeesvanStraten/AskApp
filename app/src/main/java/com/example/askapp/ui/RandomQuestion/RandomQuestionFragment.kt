package com.example.askapp.ui.RandomQuestion

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService

import kotlinx.android.synthetic.main.content_test_question.*



class RandomQuestionFragment : Fragment() {


    companion object {
        fun newInstance() = RandomQuestionFragment()
    }

    private lateinit var viewModel: RandomQuestionViewModel

    override fun onCreateView(



        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.example.askapp.R.layout.random_question_fragment, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RandomQuestionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
