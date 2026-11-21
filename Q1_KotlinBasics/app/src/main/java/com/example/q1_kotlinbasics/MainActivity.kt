package com.example.q1_kotlinbasics

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvOutput = findViewById<TextView>(R.id.tvOutput)
        val btnRun = findViewById<Button>(R.id.btnRun)

        btnRun.setOnClickListener {
            tvOutput.text = runProgram()
        }
    }

    private fun runProgram(): String {
        val text = StringBuilder()

        // 1. two integer variables
        val a = 24
        val b = 6

        // 2. arithmetic operations
        text.appendLine("Addition = " + (a + b))
        text.appendLine("Subtraction = " + (a - b))
        text.appendLine("Multiplication = " + (a * b))
        text.appendLine("Division = " + (a / b))
        text.appendLine()

        // 3. if else for pass / fail
        val marks = 72
        if (marks >= 50) {
            text.appendLine("Marks = $marks  Result = Pass")
        } else {
            text.appendLine("Marks = $marks  Result = Fail")
        }
        text.appendLine()

        // 4. loop from 1 to 10
        text.append("Numbers: ")
        for (i in 1..10) {
            text.append("$i ")
        }

        return text.toString()
    }
}
