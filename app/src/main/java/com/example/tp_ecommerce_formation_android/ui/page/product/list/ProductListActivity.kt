package com.example.tp_ecommerce_formation_android.ui.page.product.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toProduct

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val products = ProductDataSource.getProducts().map { it.toProduct() }

        findViewById<RecyclerView>(R.id.product_list).apply {
            // Apply permet de modifier l'objet sur lequel on l'utilise
            // Dans cette lambda, this est remplacé par l'instance récupérée par le findViewById
            adapter = ProductAdapter(products)
            layoutManager = LinearLayoutManager(context)
        }
    }
}