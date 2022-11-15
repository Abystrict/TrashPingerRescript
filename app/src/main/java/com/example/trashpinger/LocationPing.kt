package com.example.trashpinger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LocationPing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_ping)

        deletedraft()
        SendDraft()
    }
    private fun deletedraft(){
        val deletedraftbutton: Button = findViewById(R.id.DeleteButton)
        deletedraftbutton.setOnClickListener(){
            val toPingScreenInt = Intent(this, HomePage::class.java)
            startActivity(toPingScreenInt)
        }
    }
    private fun SendDraft(){
        val sendDraftButton: Button = findViewById(R.id.Sendbutton)
        sendDraftButton.setOnClickListener(){
            val toPingScreenInt = Intent(this, HomePage::class.java)
            startActivity(toPingScreenInt)
        }
    }
}