package com.example.trashpinger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class rewards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewards)
        BackToHome()
    }

    private fun BackToHome() {
        val BackToHomeButton: Button = findViewById(R.id.backButton)
        BackToHomeButton.setOnClickListener() {
            val ToHomeIntent = Intent(this, HomePage::class.java)
            startActivity(ToHomeIntent)
        }
    }
}