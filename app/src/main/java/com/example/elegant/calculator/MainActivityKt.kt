package com.example.elegant.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import com.example.elegant.calculator.databinding.ActivityMainBinding

private const val ADDITION = '+'
private const val SUBTRACTION = '-'
private const val MULTIPLICATION = '*'
private const val DIVISION = '/'
private const val EQU = '='
private const val EXTRA = '@'
private const val MODULUS = '%'

class MainActivityKt : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button1.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "1"
            }
            button2.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "2"
            }
            button3.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "3"
            }
            button4.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "4"
            }
            button5.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "5"
            }
            button6.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "6"
            }
            button7.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "7"
            }
            button8.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "8"
            }
            button9.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "9"
            }
            button0.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = input.text.toString() + "0"
            }
        }
    }

    private fun ifErrorOnOutput() {
        if (binding.output.text.toString() == "Error") {
            binding.output.text = ""
        }
    }

    private fun exceedLength() {
        if (binding.input.text.toString().length > 10) {
            binding.input.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        }
    }
}