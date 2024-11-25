package com.example.tp_ecommerce_formation_android.ui.page.product.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_ecommerce_formation_android.databinding.FragmentProductListBinding
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding

    private val viewModel by viewModels<ProductListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)

        binding.productList.apply {
            adapter = ProductAdapter(listOf(), ::navigateToDetails)
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { products ->
            (binding.productList.adapter as ProductAdapter).products = products
        }
    }

    private fun navigateToDetails(product: Product) {
        val action =
            ProductListFragmentDirections.actionNavigationProductListToNavigationProductDetails(
                product.id.toString()
            )
        findNavController().navigate(action)
    }
}