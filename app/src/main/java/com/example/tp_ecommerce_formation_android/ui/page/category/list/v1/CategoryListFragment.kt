package com.example.tp_ecommerce_formation_android.ui.page.category.list.v1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tp_ecommerce_formation_android.databinding.FragmentCategoryListBinding
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category
import com.example.tp_ecommerce_formation_android.ui.page.category.list.v2.CategoryListPage

class CategoryListFragment : Fragment() {

    private lateinit var binding: FragmentCategoryListBinding

    private val viewModel: CategoryListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) { categories ->
            binding.composeView.setContent {
                CategoryListPage(categoryList = categories) { category ->
                    navigateToProductList(category)
                }
            }
        }
    }

    private fun navigateToProductList(category: Category) {
        val action = CategoryListFragmentDirections.actionNavigationCategoryListToNavigationProductList(category.id.toString())
        findNavController().navigate(action)
    }
}