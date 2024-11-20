package com.example.tp_ecommerce_formation_android.ui.page.product.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.databinding.FragmentProductListBinding
import com.example.tp_ecommerce_formation_android.domain.mapper.toProduct
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product

class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)

        val products = ProductDataSource.getProducts().map { it.toProduct() }

        binding.productList.apply {
            adapter = ProductAdapter(products, ::navigateToDetails)
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }

    private fun navigateToDetails(product: Product) {
        Toast.makeText(requireContext(), "Product clicked : ${product.name}", Toast.LENGTH_SHORT).show()
    }
}