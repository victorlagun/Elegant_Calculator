package com.example.elegant.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//init const
private const val ADDITION = '+'
private const val SUBTRACTION = '-'
private const val MULTIPLICATION = '*'
private const val DIVISION = '/'
private const val EQU = '='
private const val EXTRA = '@'
private const val MODULUS = '%'

class MainActivityKotlin: AppCompatActivity() {
    private val b1 = findViewById<Button>(R.id.button1)
    private val b2 = findViewById<Button>(R.id.button2)
    private val b3 = findViewById<Button>(R.id.button3)
    private val b4 = findViewById<Button>(R.id.button4)
    private val b5 = findViewById<Button>(R.id.button5)
    private val b6 = findViewById<Button>(R.id.button6)
    private val b7 = findViewById<Button>(R.id.button7)
    private val b8 = findViewById<Button>(R.id.button8)
    private val b9 = findViewById<Button>(R.id.button9)
    private val b0 = findViewById<Button>(R.id.button0)
    private val b_equal = findViewById<Button>(R.id.button_equal)
    private val b_multi = findViewById<Button>(R.id.button_multi)
    private val b_divide = findViewById<Button>(R.id.button_divide)
    private val b_add = findViewById<Button>(R.id.button_add)
    private val b_sub = findViewById<Button>(R.id.button_sub)
    private val b_clear = findViewById<Button>(R.id.button_clear)
    private val b_dot = findViewById<Button>(R.id.button_dot)
    private val b_para1 = findViewById<Button>(R.id.button_para1)
    private val b_para2 = findViewById<Button>(R.id.button_para2)
    private val t1 = findViewById<TextView>(R.id.input)
    private val t2 = findViewById<TextView>(R.id.output)
    private var ACTION = 0.toChar()
    private var val1 = Double.NaN
    private var val2 = 0.0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}1"
        }

        b2.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}2"
        }

        b3.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}3"
        }

        b4.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}4"
        }

        b5.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}5"
        }

        b6.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}6"
        }

        b7.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}7"
        }

        b8.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}8"
        }

        b9.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}9"
        }

        b0.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = "${t1.text}0"
        }

        b_dot.setOnClickListener {
            exceedLength()
            t1.text = "${t1.text}."
        }

        b_add.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = ADDITION
                operation()
                if (!ifReallyDecimal()) {
                    t2.text = "$val1+"
                } else {
                    t2.text = val1.toInt().toString() + "+"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }

        b_sub.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = SUBTRACTION
                operation()
                if (t1.text.isNotEmpty()) if (!ifReallyDecimal()) {
                    t2.text = "$val1-"
                } else {
                    t2.text = val1.toInt().toString() + "-"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }

        b_multi.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = MULTIPLICATION
                operation()
                if (!ifReallyDecimal()) {
                    t2.text = "$val1×"
                } else {
                    t2.text = val1.toInt().toString() + "×"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }
    }

    // Remove error message that is already written there.
    private fun ifErrorOnOutput() {
        if (t2.text.toString() == "Error") {
            t2.text = ""
        }
    }

    private fun noOperation() {
        var inputExpression = t2.text.toString()
        if (!inputExpression.isEmpty() && inputExpression != "Error") {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
        }
    }

    // Whether value if a double or not
    private fun ifReallyDecimal(): Boolean {
        return val1 == val1.toInt().toDouble()
    }

    // Make text small if too many digits.
    private fun exceedLength() {
        if (t1.text.toString().length > 10) {
            t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        }
    }

    private fun operation() {
        if (!java.lang.Double.isNaN(val1)) {
            if (t2.text.toString()[0] == '-') {
                val1 = -1 * val1
            }
            val2 = t1.text.toString().toDouble()
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
            val1 = t1.text.toString().toDouble()
        }
    }
}