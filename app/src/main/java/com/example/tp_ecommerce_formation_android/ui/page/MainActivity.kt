package com.example.tp_ecommerce_formation_android.ui.page

import android.os.Bundle
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
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

        binding.bottomAppBar.setOnItemSelectedListener { item ->
            val currentFragment =
                supportFragmentManager.findFragmentById(binding.fragmentContainerView.id)
            val destination: Fragment = when (item.itemId) {
                R.id.navigation_category -> CategoryFragment()
                R.id.navigation_favorite -> FavoriteFragment()
                R.id.navigation_account -> AccountFragment()
                R.id.navigation_shops -> ShopFragment()
                else -> HomeFragment()
            }
            if (currentFragment == null || currentFragment::class.java != destination::class.java) {
                navigateToDestination(destination)
            }
            return@setOnItemSelectedListener true
        }

        onBackPressedDispatcher.addCallback(this) {
            if (supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) is HomeFragment) {
                finish()
            } else {
                navigateToDestination(HomeFragment())
            }
        }
    }

    private fun navigateToDestination(destination: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView.id, destination)
            .commit()
    }
}