package com.example.tp_ecommerce_formation_android.ui.page.category.list.v1

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.tp_ecommerce_formation_android.databinding.CategoryItemBinding

import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category

class CategoryAdapter(
    initialCategories: List<Category>,
    private val onCategoryClicked: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var categories: List<Category> = initialCategories
        set(value) {
            // On calcul la différence entre l'ancienne liste et la nouvelle liste
            val diffUtil = DiffUtilCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffUtil)
            // On met à jour la liste
            field = value
            // On informe l'adapter que les items ont changé
            diffResult.dispatchUpdatesTo(this)
        }

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
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    inner class ViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.name.text = category.name
            binding.root.setOnClickListener {
                onCategoryClicked(category)
            }
        }
    }

    inner class DiffUtilCallback(
        private val old: List<Category>,
        private val new: List<Category>,
    ): DiffUtil.Callback() {
        override fun getOldListSize(): Int = old.size

        override fun getNewListSize(): Int = new.size

        // Deux items référence la même catégory si leurs id sont identiques, qu'importe si leur nom a changé
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = old[oldItemPosition].id == new[newItemPosition].id

        // Deux items sont identiques si leurs contenu sont identiques
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = old[oldItemPosition] == new[newItemPosition]

    }

}