package com.ehb.cricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
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
            Toast.makeText(this, getString(R.string.already_in_fav), Toast.LENGTH_SHORT).show()
        }

        val backIcon = findViewById<ImageView>(R.id.backIcon)
        backIcon.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}