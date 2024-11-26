package com.example.tp_ecommerce_formation_android.ui.page.product.list.v1

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
import com.example.tp_ecommerce_formation_android.ui.page.product.list.v2.ProductListPage
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { products ->
            // Il faut afficher le composable dans le observe pour que le Composable
            // soit mis à jour en fonction de la valeur du state.
            binding.composeView.setContent {
                // Dans setContent, on peut appeler des Composables
                ProductListPage(
                    productList = products,
                    onProductClicked = { product ->
                        navigateToDetails(product)
                    }
                )
            }
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