package com.example.q2_layouts

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.GridLayout

class CalculatorActivity : AppCompatActivity() {

    private val display = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val tvDisplay = findViewById<TextView>(R.id.tvDisplay)
        val grid = findViewById<GridLayout>(R.id.gridKeys)

        // Connect every key of the grid with one listener
        for (i in 0 until grid.childCount) {
            val child = grid.getChildAt(i)
            if (child is Button) {
                child.setOnClickListener {
                    val key = child.text.toString()
                    if (key == "C") {
                        display.setLength(0)
                    } else {
                        display.append(key)
                    }
                    tvDisplay.text = if (display.isEmpty()) "0" else display.toString()
                }
            }
        }
    }
}
