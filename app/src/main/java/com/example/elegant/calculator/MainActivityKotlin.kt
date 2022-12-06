package com.example.elegant.calculator

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
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
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
}