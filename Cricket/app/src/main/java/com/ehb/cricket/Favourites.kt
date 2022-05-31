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

        val rv = findViewById<RecyclerView>(R.id.rv_fav_match)
        rv.layoutManager = LinearLayoutManager(this)
        val data = MatchAdapter().fav_match_list
        val adapter = FavMatchAdapter(data)
        rv.adapter = adapter


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
