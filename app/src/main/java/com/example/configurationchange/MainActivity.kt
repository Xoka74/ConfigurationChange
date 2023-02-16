package com.example.configurationchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var number: Int = 0
    private val tag : String = "Main activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        number = savedInstanceState?.getInt("number") ?: number

        val layout = LinearLayout(this)
        val textView = TextView(this)
        val button = Button(this)

        textView.run {
            text = number.toString()
        }

        button.run{
            setOnClickListener { onButtonClick() }
            text = getString(R.string.button_to_second_activity)
        }

        layout.run {
            addView(textView)
            addView(button)
        }

        setContentView(layout)
        Log.println(Log.INFO, tag, "Created")
    }

    private fun onButtonClick() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("number", number.toString())
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("number", number + 1)
        super.onSaveInstanceState(outState)
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
        Log.i(tag, "Paused")
        super.onPause()
    }

    override fun onDestroy() {
        Log.println(Log.INFO, tag, "Destroyed")
        super.onDestroy()
    }
}