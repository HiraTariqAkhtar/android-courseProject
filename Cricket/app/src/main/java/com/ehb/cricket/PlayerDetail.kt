package com.ehb.cricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PlayerDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)

        //Go back to list
        val back = findViewById<Button>(R.id.backBtn)
        back.setOnClickListener {
            val intent = Intent(this, Player::class.java)
            startActivity(intent)
        }
    }
}