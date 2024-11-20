package com.example.tp_ecommerce_formation_android.ui.page

import android.os.Bundle
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.databinding.ActivityMainBinding
import com.example.tp_ecommerce_formation_android.ui.page.account.AccountFragment
import com.example.tp_ecommerce_formation_android.ui.page.category.CategoryFragment
import com.example.tp_ecommerce_formation_android.ui.page.favorite.FavoriteFragment
import com.example.tp_ecommerce_formation_android.ui.page.home.HomeFragment
import com.example.tp_ecommerce_formation_android.ui.page.shop.ShopFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Récupération du NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        // Récupération du navController
        val navController = navHostFragment.navController

        // On donne le navController à notre bottom nav bar
        binding.bottomAppBar.setupWithNavController(navController)
    }
}