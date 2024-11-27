package com.example.tp_ecommerce_formation_android.ui.page.product.details.v1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.databinding.FragmentProductDetailsBinding
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.details.v2.ProductDetailsPage
import dagger.hilt.android.AndroidEntryPoint
import java.text.NumberFormat
import java.util.Locale

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding

    private val viewModel by viewModels<ProductDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { product ->
            binding.composeView.setContent {
                ProductDetailsPage(product)
            }
        }
    }
}