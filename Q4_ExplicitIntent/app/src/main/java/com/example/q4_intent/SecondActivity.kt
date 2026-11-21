package com.example.q4_intent

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // get the data from the intent
        val name = intent.getStringExtra("name")
        val roll = intent.getStringExtra("roll")
        val department = intent.getStringExtra("department")

        findViewById<TextView>(R.id.tvName).text = "Name: $name"
        findViewById<TextView>(R.id.tvRoll).text = "Roll Number: $roll"
        findViewById<TextView>(R.id.tvDepartment).text = "Department: $department"

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
