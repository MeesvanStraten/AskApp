package com.example.askapp.Classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.askapp.R

class CustomAdapter(val questionList:ArrayList<Question>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question: Question = questionList[position]

        // bind UI text elements here to specific question from list.
        holder.titleText.text = question.question

        if (question.answers.size >= 1){
            holder.contentText.text =question.answers.first()
        }
        else{
            holder.contentText.text = "Be the first to answer this question!"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.recycleritem,parent,false)

        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return questionList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleText = itemView.findViewById<TextView>(R.id.titleTextView)
        val contentText = itemView.findViewById<TextView>(R.id.contentTextView)
    }
}