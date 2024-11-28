package com.example.tp_ecommerce_formation_android.ui.page.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_ecommerce_formation_android.databinding.HomeCarouselItemBinding
import com.example.tp_ecommerce_formation_android.ui.page.home.state.LastPurchasedProduct

class LastPurchaseAdapter(
    private val products: List<LastPurchasedProduct>,
    private val onProductClicked: (LastPurchasedProduct) -> Unit,
) : RecyclerView.Adapter<LastPurchaseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HomeCarouselItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(products[position])

    inner class ViewHolder(private val binding: HomeCarouselItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: LastPurchasedProduct) {
            binding.root.setOnClickListener { onProductClicked(product) }
            binding.name.text = product.name
        }
    }
}