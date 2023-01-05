package com.example.elegant.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
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

    private var val1 = Double.NaN
    private var val2 = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        with(binding){
            button1.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}1"
            }

            button2.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}2"
            }

            button3.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}3"
            }

            button4.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}4"
            }

            button5.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}5"
            }

            button6.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}6"
            }

            button7.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}7"
            }

            button8.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}8"
            }

            button9.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}9"
            }

            button0.setOnClickListener {
                ifErrorOnOutput()
                exceedLength()
                input.text = "${input.text}0"
            }

        }
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

    private fun operation() {
        if (!java.lang.Double.isNaN(val1)) {
            if (binding.output.text.toString()[0] == '-') {
                val1 *= -1
            }
            val2 = binding.input.text.toString().toDouble()
            when (ACTION) {
                ADDITION -> val1 += val2
                SUBTRACTION -> val1 -= val2
                MULTIPLICATION -> val1 *= val2
                DIVISION -> val1 /= val2
                EXTRA -> val1 *= -1
                MODULUS -> val1 %= val2
                EQU -> {}
            }
        } else {
            val1 = binding.input.text.toString().toDouble()
        }
    }

    private fun noOperation() {
        var inputExpression: String = binding.output.text.toString()
        with(binding) {
            if (inputExpression.isNotEmpty() && inputExpression != "Error") {
                if (inputExpression.contains("-")) {
                    inputExpression = inputExpression.replace("-", "")
                    output.text = ""
                    val1 = inputExpression.toDouble()
                }
                if (inputExpression.contains("+")) {
                    inputExpression = inputExpression.replace("+", "")
                    output.text = ""
                    val1 = inputExpression.toDouble()
                }
                if (inputExpression.contains("/")) {
                    inputExpression = inputExpression.replace("/", "")
                    output.text = ""
                    val1 = inputExpression.toDouble()
                }
                if (inputExpression.contains("%")) {
                    inputExpression = inputExpression.replace("%", "")
                    output.text = ""
                    val1 = inputExpression.toDouble()
                }
                if (inputExpression.contains("×")) {
                    inputExpression = inputExpression.replace("×", "")
                    output.text = ""
                    val1 = inputExpression.toDouble()
                }
            }
        }
    }

    // Make text small if too many digits.
    private fun exceedLength() {
        if (binding.input.text.toString().length > 10) {
            binding.input.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        }
    }
}