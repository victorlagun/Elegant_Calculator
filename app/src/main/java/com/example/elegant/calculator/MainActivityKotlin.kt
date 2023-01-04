package com.example.elegant.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.elegant.calculator.databinding.ActivityMainBinding

const val ADDITION = '+'
const val SUBTRACTION = '-'
const val MULTIPLICATION = '*'
const val DIVISION = '/'
const val EQU = '='
const val EXTRA = '@'
const val MODULUS = '%'
const val ACTION = 0.toChar()

class MainActivityKotlin : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val val1 = Double.NaN
    private val val2 = 0.0

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

    // Whether value if a double or not
    private fun ifReallyDecimal(): Boolean {
        return val1 == val1.toInt().toDouble()
    }
}