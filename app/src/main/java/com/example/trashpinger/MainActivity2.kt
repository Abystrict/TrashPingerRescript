package com.example.trashpinger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        backtologin()
    }

    private fun backtologin() {
        val backtologin: Button = findViewById(R.id.BackButton)
        backtologin.setOnClickListener {
            val backtologin = Intent(this, MainActivity::class.java)
            startActivity(backtologin)
        }
    }
}