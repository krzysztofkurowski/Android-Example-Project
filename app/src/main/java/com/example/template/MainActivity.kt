package com.example.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var navController: NavController

    private val appBarConfiguration by lazy {
        AppBarConfiguration.Builder(navController.graph).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)
        setupActionBar()
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp() = NavigationUI.navigateUp(navController, appBarConfiguration)
}
