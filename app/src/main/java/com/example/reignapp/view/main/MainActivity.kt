package com.example.reignapp.view.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.reignapp.R
import com.example.reignapp.core.BaseActivity

class MainActivity : BaseActivity() {

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHost = NavHostFragment.create(R.navigation.nav_graph)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                        R.id.activity_main_container,
                        navHost
                )
                .setPrimaryNavigationFragment(navHost)
                .commitNow()
        }
    }

}