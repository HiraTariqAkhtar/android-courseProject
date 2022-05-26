package com.ehb.cricket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.R

class CountryAdapter  : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    private var countryName = arrayOf("Pakistan", "India","Australia", "England","West Indies","Bangladesh", "Pakistan", "India","Australia", "England","West Indies", "Bangladesh")
    private var countryImage = arrayOf(R.drawable.pakistan, R.drawable.india, R.drawable.australia, R.drawable.england, R.drawable.west_indies, R.drawable.bangladesh, R.drawable.pakistan, R.drawable.india, R.drawable.australia, R.drawable.england, R.drawable.west_indies, R.drawable.bangladesh)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return countryName.size
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {

        holder.name.text = countryName[position]
        holder.img.setImageResource(countryImage[position])
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img : ImageView
        var name : TextView

        init {
            img = itemView.findViewById(R.id.iv_img)
            name = itemView.findViewById(R.id.tv_name)
        }
    }
}