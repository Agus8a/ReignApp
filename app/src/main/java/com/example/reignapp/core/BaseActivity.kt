package com.example.reignapp.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reignapp.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    abstract fun getLayoutResource(): Int
}