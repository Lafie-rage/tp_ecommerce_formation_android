package com.example.tp_ecommerce_formation_android.ui.page.category.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.databinding.FragmentCategoryListBinding
import com.example.tp_ecommerce_formation_android.ui.page.category.list.placeholder.PlaceholderContent

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

        // Set the adapter
        binding.categoryList.adapter = CategoryAdapter(PlaceholderContent.ITEMS)

        return binding.root
    }
}