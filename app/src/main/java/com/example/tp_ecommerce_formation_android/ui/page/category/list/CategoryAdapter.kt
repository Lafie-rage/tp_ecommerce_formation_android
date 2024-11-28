package com.example.tp_ecommerce_formation_android.ui.page.category.list

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.databinding.CategoryItemBinding

import com.example.tp_ecommerce_formation_android.databinding.FragmentCategoryListBinding
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category

class CategoryAdapter(
    private val values: List<Category>,
    private val onCategoryClicked: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.name.text = category.name
            binding.root.setOnClickListener {
                onCategoryClicked(category)
            }
        }
    }

}