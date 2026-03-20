package com.example.recicleview
import Product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList = listOf(
            Product("Laptop", "1220€", R.drawable.ic_launcher_background),
            Product("Cards", "22€", R.drawable.ic_launcher_background),
            Product("Book", "440€", R.drawable.ic_launcher_background),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewSummary)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(productList)
    }
}
