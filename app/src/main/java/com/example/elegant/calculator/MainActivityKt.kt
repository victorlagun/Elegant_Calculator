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
private var ACTION = ' '
private var val1 = Double.NaN
private var val2 = 0.0

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
            buttonDot.setOnClickListener {
                exceedLength()
                input.text = input.text.toString() + "."
            }
            buttonPara1.setOnClickListener {
                if (input.text.isNotEmpty()) {
                    ACTION = MODULUS
                    operation()
                    if (!ifReallyDecimal()) {
                        output.text = "$val1%"
                    } else {
                        output.text = val1.toInt().toString() + "%"
                    }
                    input.text = ""
                } else {
                    output.text = "Error"
                }
            }
            buttonAdd.setOnClickListener {
                if (input.text.isNotEmpty()) {
                    ACTION = ADDITION
                    operation()
                    if (!ifReallyDecimal()) {
                        output.text = "$val1+"
                    } else {
                        output.text = val1.toInt().toString() + "+"
                    }
                    input.text = ""
                } else {
                    output.text = "Error"
                }
            }
            buttonSub.setOnClickListener {
                if (input.text.isNotEmpty()) {
                    ACTION = SUBTRACTION
                    operation()
                    if (!ifReallyDecimal()) {
                        output.text = "$val1-"
                    } else {
                        output.text = val1.toInt().toString() + "-"
                    }
                    input.text = ""
                } else {
                    output.text = "Error"
                }
            }
            buttonMulti.setOnClickListener {
                if (input.text.isNotEmpty()) {
                    ACTION = MULTIPLICATION
                    operation()
                    if (!ifReallyDecimal()) {
                        output.text = "$val1×"
                    } else {
                        output.text = val1.toInt().toString() + "×"
                    }
                    input.text = ""
                } else {
                    output.text = "Error"
                }
            }
        }
    }

    private fun operation() {
        if (!val1.isNaN()) {
            if (binding.output.text.toString()[0] == '-') {
                val1 *= (-1)
            }
            val2 = binding.input.text.toString().toDouble()
            when(ACTION) {
                ADDITION -> val1 += val2
                SUBTRACTION -> val1 -= val2
                MULTIPLICATION -> val1 += val2
                DIVISION -> val1 /= val2
                EXTRA -> val1 *= (-1)
                MODULUS -> val1 %= val2
                EQU -> {}
            }
        } else {
            val1 = binding.input.text.toString().toDouble()
        }
    }

    private fun ifReallyDecimal(): Boolean {
        return val1 == val1.toInt().toDouble()
    }

    private fun noOperation() {
        var inputExpression = binding.output.text.toString()
        if (inputExpression.isNotEmpty() && inputExpression != "Error") {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "")
                binding.output.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "")
                binding.output.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "")
                binding.output.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "")
                binding.output.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "")
                binding.output.text = ""
                val1 = inputExpression.toDouble()
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