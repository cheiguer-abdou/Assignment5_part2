package com.example.assignment_part2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val context: Context, private val products: ArrayList<Product>, private val addToCartClickListener: OnAddToCartClickListener) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val productImage: ShapeableImageView = itemView.findViewById(R.id.productImage)
        val productLogo: ImageView = itemView.findViewById(R.id.productLogo)
        var productName: TextView = itemView.findViewById(R.id.productName)
        var productDescription: TextView = itemView.findViewById(R.id.productDescription)
        var productPrice: TextView = itemView.findViewById(R.id.productPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = products[position]
//        val cartList = ArrayList<Product>()
        holder.productImage.setImageResource(currentItem.productImage)
        holder.productLogo.setImageResource(currentItem.productLogo)
        holder.productName.text = currentItem.productName
        holder.productDescription.text = currentItem.productDescription
        holder.productPrice.text = "$ " + currentItem.productPrice.toString()

        val addButton: Button = holder.itemView.findViewById(R.id.addButton)

        holder.productImage.setOnClickListener{
            val itemView = Intent(context, ItemActivity::class.java)
            itemView.putExtra("currentItem", currentItem)
            context.startActivity(itemView)
        }
        addButton.setOnClickListener {
            addToCartClickListener.onAddToCartClick(currentItem)
        }

    }
}