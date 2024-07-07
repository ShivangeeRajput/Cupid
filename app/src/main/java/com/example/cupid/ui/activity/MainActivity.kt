package com.example.cupid.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.cupid.R

class MainActivity : AppCompatActivity(){
private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    }
    override fun onSupportNavigateUp(): Boolean {
        navController=findNavController(R.id.navHostFragmentContainerView)
        return  navController.navigateUp() || super.onSupportNavigateUp()
    }
}