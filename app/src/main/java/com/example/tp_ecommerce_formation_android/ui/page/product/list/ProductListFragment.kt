package com.example.tp_ecommerce_formation_android.ui.page.product.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.databinding.FragmentProductListBinding
import com.example.tp_ecommerce_formation_android.domain.mapper.toProduct
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product
import java.util.UUID

class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding

    private val args: ProductListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)

        val categoryId = UUID.fromString(args.categoryId)
        val products = ProductDataSource.getProductsByCategoryId(categoryId)
            .map { product ->
                product.toProduct()
            }

        binding.productList.apply {
            adapter = ProductAdapter(products, ::navigateToDetails)
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }

    private fun navigateToDetails(product: Product) {
        val action = ProductListFragmentDirections.actionNavigationProductListToNavigationProductDetails(product.id.toString())
        findNavController().navigate(action)
    }
}