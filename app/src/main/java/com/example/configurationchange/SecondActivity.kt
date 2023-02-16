package com.example.configurationchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private val tag : String = "Second activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        val textView = TextView(this)
        val number = intent.extras!!.getString("number")!!.toInt()
        textView.text = (number * number).toString()

        super.onCreate(savedInstanceState)
        setContentView(textView)
        Log.println(Log.INFO,tag,"Created")
    }

    override fun onStart() {
        Log.println(Log.INFO, tag, "Started")
        super.onStart()
    }

    override fun onResume() {
        Log.println(Log.INFO, tag, "Resumed")
        super.onResume()
    }

    override fun onStop() {
        Log.println(Log.INFO, tag, "Stopped")
        super.onStop()
    }

    override fun onPause() {
        Log.println(Log.INFO, tag, "Paused")
        super.onPause()
    }

    override fun onDestroy() {
        Log.println(Log.INFO, tag, "Destroyed")
        super.onDestroy()
    }
}