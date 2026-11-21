package com.example.q4_intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etRoll = findViewById<EditText>(R.id.etRoll)
        val etDepartment = findViewById<EditText>(R.id.etDepartment)
        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            val name = etName.text.toString()
            val roll = etRoll.text.toString()
            val department = etDepartment.text.toString()

            // explicit intent
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("roll", roll)
            intent.putExtra("department", department)
            startActivity(intent)
        }
    }
}
