package com.example.chatwise_assignment.rvexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.chatwise_assignment.R

class RecyclerView : AppCompatActivity() {
    lateinit var recyclerViewExample:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
//        recyclerViewExample=findViewById<RecyclerView>(R.id.recyclerViewExample)
//
//        recyclerViewExample.layoutManager=LayoutManager
    }
}