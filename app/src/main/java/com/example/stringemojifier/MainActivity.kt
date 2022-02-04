package com.example.stringemojifier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.stringemojifier.databinding.ActivityMainBinding
import com.example.stringemojifier.databinding.FragmentEmojiBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(this.layoutInflater)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {

        return NavigationUI.navigateUp(navController,null)

    }
}