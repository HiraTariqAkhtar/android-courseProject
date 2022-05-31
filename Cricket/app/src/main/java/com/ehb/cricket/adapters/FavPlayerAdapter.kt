package com.ehb.cricket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.R
import com.ehb.cricket.classes.Countries
import com.ehb.cricket.classes.Matches
import com.ehb.cricket.classes.Players

class FavPlayerAdapter: RecyclerView.Adapter<FavPlayerAdapter.ViewHolder>()  {

    val countryList = mutableListOf<Countries>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavPlayerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fav_card_layout, parent, false)
        val vh = ViewHolder(v)

        return vh
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        init {

        }
    }

}