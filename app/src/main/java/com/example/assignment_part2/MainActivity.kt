package com.example.assignment_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnAddToCartClickListener{
    private lateinit var recyclerView: RecyclerView
    private val cart = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = ArrayList<Product>()

        val cartBtn = findViewById<Button>(R.id.cart)
        products.add(Product(R.drawable.ipad, R.drawable.applelogo,"iPad", "iPad Pro 11-inch", 400.0))
        products.add(Product(R.drawable.macbook, R.drawable.applelogo,"MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00))
        products.add(Product(R.drawable.dellinspiron, R.drawable.delllogo,"Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00))
        products.add(Product(R.drawable.logitechkeyboard ,R.drawable.logitechlogo,"Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00))
        products.add(Product(R.drawable.macbook, R.drawable.applelogo,"MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00))

        cartBtn.setOnClickListener {
            showToast("Added Products: ${cart.joinToString(", ") { it.productName?: "Unknown Product"}}")
        }

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MyAdapter(this, products, this)
    }

    private fun showToast(message: CharSequence?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onAddToCartClick(product: Product) {
        cart.add(product)
    }
}