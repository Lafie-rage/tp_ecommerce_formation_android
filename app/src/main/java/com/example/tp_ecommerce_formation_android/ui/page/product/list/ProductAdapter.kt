package com.example.tp_ecommerce_formation_android.ui.page.product.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product
import java.text.NumberFormat
import java.util.Locale

class ProductAdapter(
    private val products: List<Product>
): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(products[position])

    inner class ViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val nameView: TextView = itemView.findViewById(R.id.name)
        private val descriptionView: TextView = itemView.findViewById(R.id.description)
        private val statusView: TextView = itemView.findViewById(R.id.status)
        private val priceView: TextView = itemView.findViewById(R.id.price)

        fun bind(product: Product) {
            nameView.text = product.name
            descriptionView.text = product.description
            val statusStringRes = if (product.isAvailable) R.string.available else R.string.unavailable
            statusView.text = itemView.context.getString(statusStringRes)
            val priceFormatter =  NumberFormat.getCurrencyInstance(Locale.FRANCE)
            priceView.text = priceFormatter.format(product.price)
        }
    }
}