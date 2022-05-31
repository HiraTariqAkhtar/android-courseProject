package com.ehb.cricket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.adapters.*
import com.ehb.cricket.classes.Countries
import com.ehb.cricket.classes.Matches
import com.ehb.cricket.classes.Players
import java.util.ArrayList

class Favourites : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        val match_rv = findViewById<RecyclerView>(R.id.rv_fav_match)
        match_rv.layoutManager = LinearLayoutManager(this)
        val match_data = MatchAdapter().fav_match_list
        val match_adapter = FavMatchAdapter(match_data)
        match_rv.adapter = match_adapter

        val player_rv = findViewById<RecyclerView>(R.id.rv_fav_player)
        player_rv.layoutManager = LinearLayoutManager(this)
        val player_data = PlayerAdapter().fav_player_list
        val player_adapter = FavPlayerAdapter(player_data)
        player_rv.adapter = player_adapter

        val country_rv = findViewById<RecyclerView>(R.id.rv_fav_country)
        country_rv.layoutManager = LinearLayoutManager(this)
        val country_data = CountryAdapter().fav_country_list
        val country_adapter = FavCountryAdapter(country_data)
        country_rv.adapter = country_adapter


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
