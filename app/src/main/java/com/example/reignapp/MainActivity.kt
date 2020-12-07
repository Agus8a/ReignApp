package com.example.reignapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost = NavHostFragment.create(R.navigation.nav_graph)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(
                            R.id.fragmentContainer,
                            navHost
                    )
                    .setPrimaryNavigationFragment(navHost)
                    .commitNow()
        }
    }
}