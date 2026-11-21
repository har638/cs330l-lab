package com.example.q5_lifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val tag = "LifecycleDemo"
    private var counter = 0
    private val logText = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addLog("onCreate()")

        findViewById<Button>(R.id.btnMinimize).setOnClickListener {
            moveTaskToBack(true)
        }
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            counter = 0
            logText.setLength(0)
            findViewById<TextView>(R.id.tvLog).text = ""
        }
    }

    private fun addLog(message: String) {
        counter++
        Log.d(tag, "$counter. $message")
        logText.appendLine("$counter. $message")
        findViewById<TextView>(R.id.tvLog).text = logText.toString()
    }

    override fun onStart() {
        super.onStart()
        addLog("onStart()")
    }

    override fun onResume() {
        super.onResume()
        addLog("onResume()")
    }

    override fun onPause() {
        super.onPause()
        addLog("onPause()")
    }

    override fun onStop() {
        super.onStop()
        addLog("onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        addLog("onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        addLog("onDestroy()")
    }
}
