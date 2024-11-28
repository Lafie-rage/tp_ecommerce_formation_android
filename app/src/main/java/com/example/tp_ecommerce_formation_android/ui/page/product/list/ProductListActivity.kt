package com.example.tp_ecommerce_formation_android.ui.page.product.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toProduct
import com.example.tp_ecommerce_formation_android.ui.page.product.details.PRODUCT_ID_EXTRA_KEY
import com.example.tp_ecommerce_formation_android.ui.page.product.details.ProductDetailsActivity
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val products = ProductDataSource.getProducts().map { it.toProduct() }

        findViewById<RecyclerView>(R.id.product_list).apply {
            // Apply permet de modifier l'objet sur lequel on l'utilise
            // Dans cette lambda, this est remplacé par l'instance récupérée par le findViewById
            adapter = ProductAdapter(products, ::navigateToDetails)
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun navigateToDetails(product: Product) {
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra(PRODUCT_ID_EXTRA_KEY, product.id)
        startActivity(intent)
    }
}