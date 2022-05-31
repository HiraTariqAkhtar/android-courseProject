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

class FavMatchAdapter(val matchList : List<Matches>): RecyclerView.Adapter<FavMatchAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMatchAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fav_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return matchList.size
    }

    override fun onBindViewHolder(holder: FavMatchAdapter.ViewHolder, position: Int) {
        val list = matchList[position]

        holder.name.text = list.name
        holder.img.setImageResource(list.img)
        holder.img2.setImageResource(list.img2)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img : ImageView = itemView.findViewById(R.id.iv_img)
        var img2 : ImageView = itemView.findViewById(R.id.iv_img2)
        var name : TextView = itemView.findViewById(R.id.tv_name)

    }
}