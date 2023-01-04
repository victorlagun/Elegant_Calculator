package com.example.elegant.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.elegant.calculator.databinding.ActivityMainBinding

@SuppressLint("SetTextI18n")
class MainActivityKotlin : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }

    // Remove error message that is already written there.
    private fun ifErrorOnOutput() {
        if ("${binding.output.text}" == "Error") {
            binding.output.text = ""
        }
    }
}