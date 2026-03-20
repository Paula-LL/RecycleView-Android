package com.example.recicleview

import Product
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SummaryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var totalPriceText: TextView
    private lateinit var goBackButton: Button

    private var itemList: List<Product> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.summaryactivity_layout)

        recyclerView = findViewById(R.id.recyclerViewSummary)
        totalPriceText = findViewById(R.id.summaryTotal)
        goBackButton = findViewById(R.id.goBckButton)
        recyclerView.layoutManager = LinearLayoutManager(this)

        goBackButton.setOnClickListener {
            finish()
        }
    }

}