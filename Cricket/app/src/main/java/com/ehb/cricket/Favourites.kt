package com.ehb.cricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.ehb.cricket.classes.Countries
import com.ehb.cricket.classes.Matches
import com.ehb.cricket.classes.Players

class Favourites : AppCompatActivity() {

    val matchList = mutableListOf<Matches>()
    val playerList = mutableListOf<Players>()
    val countryList = mutableListOf<Countries>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        val favIcon = findViewById<ImageView>(R.id.FavIcon)
        favIcon.setOnClickListener {
            val intent = Intent(this, Favourites::class.java)
            startActivity(intent)
        }

        val backIcon = findViewById<ImageView>(R.id.backIcon)
        backIcon.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}