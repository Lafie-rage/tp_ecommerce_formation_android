package com.example.tp_ecommerce_formation_android.ui.page.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.databinding.FragmentShopBinding

class ShopFragment : Fragment() {

    private lateinit var binding: FragmentShopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

}