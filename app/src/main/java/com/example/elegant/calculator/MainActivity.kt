package com.example.elegant.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var b1: Button = findViewById(R.id.button1)
    private var b2: Button = findViewById(R.id.button2)
    private var b3: Button = findViewById(R.id.button3)
    private var b4: Button = findViewById(R.id.button4)
    private var b5: Button = findViewById(R.id.button5)
    private var b6: Button = findViewById(R.id.button6)
    private var b7: Button = findViewById(R.id.button7)
    private var b8: Button = findViewById(R.id.button8)
    private var b9: Button = findViewById(R.id.button9)
    private var b0: Button = findViewById(R.id.button0)
    private var bEqual: Button = findViewById(R.id.button_equal)
    private var bMulti: Button = findViewById(R.id.button_multi)
    private var bDivide: Button = findViewById(R.id.button_divide)
    private var bAdd: Button = findViewById(R.id.button_add)
    private var bSub: Button = findViewById(R.id.button_sub)
    private var bClear: Button = findViewById(R.id.button_clear)
    private var bDot: Button = findViewById(R.id.button_dot)
    private var bPara1: Button = findViewById(R.id.button_para1)
    private var bPara2: Button = findViewById(R.id.button_para2)
    private var t1: TextView = findViewById(R.id.input)
    private var t2: TextView = findViewById(R.id.output)
    private val ADDITION = '+'
    private val SUBTRACTION = '-'
    private val MULTIPLICATION = '*'
    private val DIVISION = '/'
    private val EQU = '='
    private val EXTRA = '@'
    private val MODULUS = '%'
    private var ACTION = 0.toChar()
    private var val1 = Double.NaN
    private var val2 = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "1"
        }

        b2.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "2"
        }

        b3.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "3"
        }

        b4.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "4"
        }

        b5.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "5"
        }

        b6.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "6"
        }

        b7.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "7"
        }

        b8.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "8"
        }

        b9.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "9"
        }

        b0.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "0"
        }

        bDot.setOnClickListener {
            exceedLength()
            t1.text = t1.text.toString() + "."
        }

        bPara1.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = MODULUS
                operation()
                if (!ifReallyDecimal()) {
                    t2.text = "$val1%"
                } else {
                    t2.text = val1.toInt().toString() + "%"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }

        bAdd.setOnClickListener {
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

        bSub.setOnClickListener {
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

        bMulti.setOnClickListener {
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

        bDivide.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = DIVISION
                operation()
                if (ifReallyDecimal()) {
                    t2.text = val1.toInt().toString() + "/"
                } else {
                    t2.text = "$val1/"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }

        bPara2.setOnClickListener {
            if (!t2.text.toString().isEmpty() || !t1!!.text.toString().isEmpty()) {
                val1 = t1.text.toString().toDouble()
                ACTION = EXTRA
                t2.text = "-" + t1.text.toString()
                t1.text = ""
            } else {
                t2.text = "Error"
            }
        }

        bEqual.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                operation()
                ACTION = EQU
                if (!ifReallyDecimal()) {
                    t2.text = val1.toString()
                } else {
                    t2.text = val1.toInt().toString()
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }

        bClear.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                val name: CharSequence = t1.text.toString()
                t1.text = name.subSequence(0, name.length - 1)
            } else {
                val1 = Double.NaN
                val2 = Double.NaN
                t1.text = ""
                t2.text = ""
            }
        }

        // Empty text views on long click.
        bClear.setOnLongClickListener {
            val1 = Double.NaN
            val2 = Double.NaN
            t1.text = ""
            t2.text = ""
            true
        }
    }

    !private fun operation() {
        if (!java.lang.Double.isNaN(val1)) {
            if (t2.text.toString()[0] == '-') {
                val1 *= -1
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

    // Remove error message that is already written there.
    !private fun ifErrorOnOutput() {
        if (t2.text.toString() == "Error") {
            t2.text = ""
        }
    }

    // Whether value if a double or not
    !private fun ifReallyDecimal(): Boolean {
        return val1 == val1.toInt().toDouble()
    }

    !private fun noOperation() {
        var inputExpression = t2.text.toString()
        if (inputExpression.isNotEmpty() && inputExpression != "Error") {
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

    // Make text small if too many digits.
    !private fun exceedLength() {
        if (t1.text.toString().length > 10) {
            t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        }
    }
}