package com.example.tp_ecommerce_formation_android.ui.page.product.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.databinding.FragmentProductDetailsBinding
import com.example.tp_ecommerce_formation_android.domain.mapper.toProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetails
import java.text.NumberFormat
import java.util.Locale

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)

        val productId = ProductDataSource.getProducts().first().id
        val product = ProductDataSource.getProductById(productId)!!.toProductDetails()

        bind(product)

        return binding.root
    }

    private fun bind(product: ProductDetails) {
        with(binding) {
            name.text = product.name
            category.text = product.category
            val priceFormater = NumberFormat.getCurrencyInstance(Locale.FRANCE)
            price.text = priceFormater.format(product.price)
            addToCartButton.isVisible = product.isAvailable
            description.text = product.description
            rateStar1.setImageResource(
                when {
                    product.averageRate >= 1 -> R.drawable.ic_star_filled
                    product.averageRate >= 0.5 -> R.drawable.ic_star_half_filled
                    else -> R.drawable.ic_star_outlined
                }
            )
            rateStar2.setImageResource(
                when {
                    product.averageRate >= 2 -> R.drawable.ic_star_filled
                    product.averageRate >= 1.5 -> R.drawable.ic_star_half_filled
                    else -> R.drawable.ic_star_outlined
                }
            )
            rateStar3.setImageResource(
                when {
                    product.averageRate >= 3 -> R.drawable.ic_star_filled
                    product.averageRate >= 2.5 -> R.drawable.ic_star_half_filled
                    else -> R.drawable.ic_star_outlined
                }
            )
            rateStar4.setImageResource(
                when {
                    product.averageRate >= 4 -> R.drawable.ic_star_filled
                    product.averageRate >= 3.5 -> R.drawable.ic_star_half_filled
                    else -> R.drawable.ic_star_outlined
                }
            )
            rateStar5.setImageResource(
                when {
                    product.averageRate == 5.0 -> R.drawable.ic_star_filled
                    product.averageRate >= 4.5 -> R.drawable.ic_star_half_filled
                    else -> R.drawable.ic_star_outlined
                }
            )
            rateCount.text = getString(R.string.rate_count, product.averageRate, product.rateCount)
        }
    }
}