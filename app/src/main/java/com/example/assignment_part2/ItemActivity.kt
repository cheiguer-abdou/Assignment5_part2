package com.example.assignment_part2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItemActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_activity)

        val currentItem = intent.getParcelableExtra<Product>("currentItem",)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val name = findViewById<TextView>(R.id.name)
        val description = findViewById<TextView>(R.id.description)
        val price = findViewById<TextView>(R.id.price)
        val homeBtn = findViewById<TextView>(R.id.homebtn)

        homeBtn.setOnClickListener {
            finish()
        }

        if (currentItem != null) {
            imageView.setImageResource(currentItem.productImage)
            name.text = currentItem.productName
            description.text = currentItem.productDescription
            price.text = "$ " + currentItem.productPrice.toString()
        }

    }
}