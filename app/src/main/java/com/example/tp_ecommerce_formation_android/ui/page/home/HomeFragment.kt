package com.example.tp_ecommerce_formation_android.ui.page.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.databinding.FragmentHomeBinding
import com.example.tp_ecommerce_formation_android.domain.mapper.toLastPurchasedProduct

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        val products = ProductDataSource.getProducts().map { it.toLastPurchasedProduct() }
        val adapter = LastPurchaseAdapter(products) { product ->
            Toast.makeText(requireContext(), "Clicked on ${product.name}", Toast.LENGTH_SHORT).show()
        }
        binding.carousel.adapter = adapter
    }

    override fun onDestroyView()  {
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        super.onDestroyView()
    }

}