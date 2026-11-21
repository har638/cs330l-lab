package com.example.q3_calculator

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirst = findViewById<EditText>(R.id.etFirst)
        val etSecond = findViewById<EditText>(R.id.etSecond)
        val spinner = findViewById<Spinner>(R.id.spinnerOperation)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)

        val operations = arrayOf("+", "-", "*", "/")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, operations)

        btnClear.setOnClickListener {
            etFirst.setText("")
            etSecond.setText("")
            tvResult.text = "Result = "
        }

        btnCalculate.setOnClickListener {
            val firstText = etFirst.text.toString()
            val secondText = etSecond.text.toString()

            if (firstText.isEmpty() || secondText.isEmpty()) {
                tvResult.text = "Please enter both numbers"
                return@setOnClickListener
            }

            val first = firstText.toDouble()
            val second = secondText.toDouble()
            val operation = spinner.selectedItem.toString()

            val result = when (operation) {
                "+" -> first + second
                "-" -> first - second
                "*" -> first * second
                else -> {
                    if (second == 0.0) {
                        tvResult.text = "Cannot divide by zero"
                        return@setOnClickListener
                    }
                    first / second
                }
            }

            tvResult.text = "Result = $result"
        }
    }
}
