package com.example.elegant.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.elegant.calculator.databinding.ActivityMainBinding

private const val ADDITION = '+'
private const val SUBTRACTION = '-'
private const val MULTIPLICATION = '*'
private const val DIVISION = '/'
private const val EQU = '='
private const val EXTRA = '@'
private const val MODULUS = '%'

class MainActivityKt: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun ifErrorOnOutput() {
        if (binding.output.text.toString() == "Error") {
            binding.output.text = ""
        }
    }
}