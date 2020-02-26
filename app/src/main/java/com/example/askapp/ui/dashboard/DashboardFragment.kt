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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.askapp.Classes.CustomAdapter
import com.example.askapp.Classes.Question
import com.example.askapp.R
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
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

         lateinit var database: DatabaseReference
        database = FirebaseDatabase.getInstance().reference


        val listOfQuestions: ArrayList<Question?> = arrayListOf()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        val questionListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                for (singleSnapshot in dataSnapshot.children) {
                    val question =
                        singleSnapshot.getValue(Question::class.java)
                    listOfQuestions.add(question)

                }

                val adapter = CustomAdapter(listOfQuestions)
                recyclerView.adapter = adapter

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                // ...
            }
        }
        database.addValueEventListener(questionListener)
        recyclerView.layoutManager = LinearLayoutManager(this.context,RecyclerView.VERTICAL,false)


    }
}



