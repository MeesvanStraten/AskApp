package com.example.askapp.ui.dashboard

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.askapp.Classes.Question
import com.example.askapp.R
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FirebaseApp.initializeApp(this.requireContext())
        var db = FirebaseFirestore.getInstance()

        val listOfQuestions: MutableList<Question> = arrayListOf()


        lateinit var listView: ListView
        listView = view.findViewById(R.id.listview)


        db.collection("questions")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listOfQuestions.add(Question(document.getString("question").toString()))
                }
            }

        var arrayAdapter = ArrayAdapter<Question>(context!!,android.R.layout.simple_list_item_1,listOfQuestions)
        listView.adapter = arrayAdapter
    }
}



