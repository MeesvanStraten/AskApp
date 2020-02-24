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
import com.example.askapp.R
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.lang.Exception

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
        val db = FirebaseFirestore.getInstance()

         lateinit var listView: ListView

        listView = view.findViewById(R.id.listview)

        var loadedQuestions :MutableList<String> = arrayListOf()

        val data = db.collection("questions")
            .get()



        db.collection("questions")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    loadedQuestions.add(document.data.toString())
                }

                val adapter = ArrayAdapter(this.requireContext(),android.R.layout.simple_list_item_1,loadedQuestions)
                listview.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }





    }
}


