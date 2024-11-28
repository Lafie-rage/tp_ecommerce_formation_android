package com.example.tp_ecommerce_formation_android.ui.page.product.details

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.databinding.ActivityProductDetailsBinding
import com.example.tp_ecommerce_formation_android.domain.mapper.toProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetails
import java.text.NumberFormat
import java.util.Locale
import java.util.UUID

const val PRODUCT_ID_EXTRA_KEY = "PRODUCT_ID"

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val productId =
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra(PRODUCT_ID_EXTRA_KEY, UUID::class.java)!!
            } else {
                intent.getSerializableExtra(PRODUCT_ID_EXTRA_KEY)!! as UUID
            }

        val product = ProductDataSource.getById(productId)!!.toProductDetails()

        bind(product)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
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