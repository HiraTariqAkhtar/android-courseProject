package com.ehb.cricket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.R
import com.ehb.cricket.classes.Countries
import com.ehb.cricket.classes.Matches
import com.ehb.cricket.classes.Players

class FavPlayerAdapter(val playerList: List<Players>): RecyclerView.Adapter<FavPlayerAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavPlayerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fav_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = playerList[position]

        holder.name.text = list.name
        holder.img.setImageResource(list.img)
        holder.img2.setImageResource(list.team)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img : ImageView = itemView.findViewById(R.id.iv_img)
        var img2 : ImageView = itemView.findViewById(R.id.iv_img2)
        var name : TextView = itemView.findViewById(R.id.tv_name)
    }

}