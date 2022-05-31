package com.ehb.cricket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.R
import com.ehb.cricket.classes.Countries

class FavCountryAdapter(val countryList: List<Countries>): RecyclerView.Adapter<FavCountryAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavCountryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fav_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = countryList[position]

        holder.name.text = list.name
        holder.img.setImageResource(list.flag)
        holder.img2.setImageResource(list.teamImg)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img : ImageView = itemView.findViewById(R.id.iv_img)
        var img2 : ImageView = itemView.findViewById(R.id.iv_img2)
        var name : TextView = itemView.findViewById(R.id.tv_name)
    }

}