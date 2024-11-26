package com.example.tp_ecommerce_formation_android.ui.page.product.list.v1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product
import java.text.NumberFormat
import java.util.Locale

class ProductAdapter(
    initialProducts: List<Product>,
    private val onProductClicked: (Product) -> Unit,
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    var products: List<Product> = initialProducts
        set(value) {
            val diffUtil = DiffUtilCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffUtil)
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(products[position])

    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val nameView: TextView = itemView.findViewById(R.id.name)
        private val descriptionView: TextView = itemView.findViewById(R.id.description)
        private val statusView: TextView = itemView.findViewById(R.id.status)
        private val priceView: TextView = itemView.findViewById(R.id.price)

        fun bind(product: Product) {
            itemView.rootView.setOnClickListener {
                onProductClicked(product)
            }
            nameView.text = product.name
            descriptionView.text = product.description
            val statusStringRes =
                if (product.isAvailable) R.string.available else R.string.unavailable
            statusView.text = itemView.context.getString(statusStringRes)
            val priceFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE)
            priceView.text = priceFormatter.format(product.price)
        }
    }

    inner class DiffUtilCallback(
        private val old: List<Product>,
        private val new: List<Product>,
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = old.size

        override fun getNewListSize(): Int = new.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            old[oldItemPosition].id == new[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            old[oldItemPosition] == new[newItemPosition]
    }
}