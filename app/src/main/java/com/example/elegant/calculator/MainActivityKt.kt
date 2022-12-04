package com.example.elegant.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.elegant.calculator.databinding.ActivityMainBinding

class MainActivityKt: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}