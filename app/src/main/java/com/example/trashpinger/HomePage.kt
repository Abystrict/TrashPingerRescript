package com.example.trashpinger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        backtologin()
        tomap()
    }
    // functions
    private fun backtologin() {
        val backtologin: Button = findViewById(R.id.BackButton)
        backtologin.setOnClickListener {
            val backtologin = Intent(this, LoginPage::class.java)
            startActivity(backtologin)
        }
    }
    private fun tomap(){
        val toMapButton:Button=findViewById(R.id.ToMapButton)
        toMapButton.setOnClickListener(){
            val toMapIntent = Intent(this, MapsActivity::class.java)
            startActivity(toMapIntent)
        }
    }
}