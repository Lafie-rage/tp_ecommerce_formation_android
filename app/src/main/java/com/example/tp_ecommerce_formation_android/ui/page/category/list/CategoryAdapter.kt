package com.example.tp_ecommerce_formation_android.ui.page.category.list

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tp_ecommerce_formation_android.R

import com.example.tp_ecommerce_formation_android.ui.page.category.list.placeholder.PlaceholderContent.PlaceholderItem
import com.example.tp_ecommerce_formation_android.databinding.FragmentCategoryListBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class CategoryAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCategoryListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
//        holder.idView.text = item.id
//        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentCategoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}