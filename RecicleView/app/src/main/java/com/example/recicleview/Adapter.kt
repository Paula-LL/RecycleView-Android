package com.example.recicleview

import Product
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val productList: List<Product>,
    private val onUpdate: () -> Unit
) : RecyclerView.Adapter<Adapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val productUnits: TextView = itemView.findViewById(R.id.productUnits)
        val addButton: Button = itemView.findViewById(R.id.addButton)
        val eliminateButton: Button = itemView.findViewById(R.id.eliminateButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.name
        holder.productPrice.text = "${product.price}€"
        holder.productImage.setImageResource(product.imageResID)
        holder.productUnits.text = product.quantity.toString()

        holder.addButton.setOnClickListener {
            product.quantity++
            notifyItemChanged(position)
            onUpdate()
        }

        holder.eliminateButton.setOnClickListener {
            if (product.quantity > 0) {
                product.quantity--
                notifyItemChanged(position)
                onUpdate()
            }
        }
    }

    override fun getItemCount() :Int {
        return productList.size
    }
}

