package com.example.tp_ecommerce_formation_android.ui.page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Liage de la barre d'action avec notre Activity
        setSupportActionBar(binding.toolbar)

        // Récupération du NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        // Récupération du navController
        val navController = navHostFragment.navController

        // Configuration des destination la barre d'action
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_search,
                R.id.navigation_favorite,
                R.id.navigation_account,
                R.id.navigation_shops,
            )
        )

        // Liage du navController avec la barre d'action
        setupActionBarWithNavController(navController, appBarConfiguration)

        // On donne le navController à notre bottom nav bar
        binding.bottomAppBar.setupWithNavController(navController)
    }
}