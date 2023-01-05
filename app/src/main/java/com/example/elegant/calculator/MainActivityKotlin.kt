package com.example.elegant.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
import android.view.View.OnLongClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.elegant.calculator.databinding.ActivityMainBinding

const val ADDITION = '+'
const val SUBTRACTION = '-'
const val MULTIPLICATION = '*'
const val DIVISION = '/'
const val EQU = '='
const val EXTRA = '@'
const val MODULUS = '%'


class MainActivityKotlin : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var val1 = Double.NaN
    private var val2 = 0.0
    private var ACTION = 0.toChar()

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

            buttonDot.setOnClickListener {
                exceedLength()
                input.text = "${input.text}."
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
                    input.text = null
                } else {
                    input.text = "Error"
                }
            }

            buttonAdd.setOnClickListener{
                if (input.text.isNotEmpty()) {
                    ACTION = ADDITION
                    operation()
                    if (!ifReallyDecimal()) {
                        output.text = "$val1+"
                    } else {
                        output.text = val1.toInt().toString() + "+"
                    }
                    input.text = null
                } else {
                    input.text = "Error"
                }
            }

            buttonSub.setOnClickListener {
                if (input.text.isNotEmpty()) {
                    ACTION = SUBTRACTION
                    operation()
                    if (input.text.isNotEmpty()) if (!ifReallyDecimal()) {
                        output.text = "$val1-"
                    } else {
                        output.text = val1.toInt().toString() + "-"
                    }
                    input.text = null
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
                    input.text = null
                } else {
                    output.text = "Error"
                }
            }

            buttonDivide.setOnClickListener {
                if (input.text.isNotEmpty()) {
                    ACTION = DIVISION
                    operation()
                    if (ifReallyDecimal()) {
                        output.text = val1.toInt().toString() + "/"
                    } else {
                        output.text = "$val1/"
                    }
                    input.text = null
                } else {
                    output.text = "Error"
                }
            }

            buttonPara2.setOnClickListener {
                if (output.text.toString().isNotEmpty() || input.text.toString().isNotEmpty()) {
                    val1 = input.text.toString().toDouble()
                    ACTION = EXTRA
                    output.text = "-" + input.text.toString()
                    input.text = ""
                } else {
                    output.text = "Error"
                }
            }

            buttonEqual.setOnClickListener {
                if (input.text.isNotEmpty()) {
                    operation()
                    ACTION = EQU
                    if (!ifReallyDecimal()) {
                        output.text = val1.toString()
                    } else {
                        output.text = val1.toInt().toString()
                    }
                    input.text = null
                } else {
                    output.text = "Error"
                }
            }

            buttonClear.setOnClickListener {
                if (input.text.isNotEmpty()) {
                    val name: CharSequence = input.text.toString()
                    input.text = name.subSequence(0, name.length - 1)
                } else {
                    val1 = Double.NaN
                    val2 = Double.NaN
                    input.text = ""
                    output.text = ""
                }
            }

            // Empty text views on long click.
            buttonClear.setOnLongClickListener(OnLongClickListener {
                val1 = Double.NaN
                val2 = Double.NaN
                input.text = ""
                output.text = ""
                true
            })

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