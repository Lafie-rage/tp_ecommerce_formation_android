package com.example.tp_ecommerce_formation_android.ui.page.category.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.findNavController
import com.example.tp_ecommerce_formation_android.data.source.CategoryDataSource
import com.example.tp_ecommerce_formation_android.data.source.CategoryDataSource.getCategories
import com.example.tp_ecommerce_formation_android.databinding.FragmentCategoryListBinding
import com.example.tp_ecommerce_formation_android.domain.mapper.toCategory
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category

/**
 * A fragment representing a list of Items.
 */
class CategoryListFragment : Fragment() {

    private lateinit var binding: FragmentCategoryListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryListBinding.inflate(inflater, container, false)

        val categories = getCategories().map { it.toCategory() }

        // Set the adapter
        binding.categoryList.adapter = CategoryAdapter(categories) { category ->
            navigateToProductList(category)
        }

        return binding.root
    }

    private fun navigateToProductList(category: Category) {
        val action = CategoryListFragmentDirections.actionNavigationCategoryListToNavigationProductList(category.id.toString())
        findNavController().navigate(action)
    }
}