package com.ehb.cricket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.R

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    private var playerName = arrayOf("Shadab Khan", "Virat Kohli","Shadab Khan", "Virat Kohli","Shadab Khan", "Virat Kohli","Shadab Khan", "Virat Kohli","Shadab Khan", "Virat Kohli")
    private var playerCountry = arrayOf("Pakistan", "India","Pakistan", "India", "Pakistan", "India", "Pakistan", "India", "Pakistan", "India")
    private var playerImage = arrayOf(R.drawable.shadab, R.drawable.kohli, R.drawable.shadab, R.drawable.kohli,R.drawable.shadab, R.drawable.kohli,R.drawable.shadab, R.drawable.kohli,R.drawable.shadab, R.drawable.kohli)
    private var playerTeamImage = arrayOf(R.drawable.pakistan, R.drawable.india, R.drawable.pakistan, R.drawable.india,R.drawable.pakistan, R.drawable.india,R.drawable.pakistan, R.drawable.india,R.drawable.pakistan, R.drawable.india)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return playerName.size
    // return 10
    }

    override fun onBindViewHolder(holder: PlayerAdapter.ViewHolder, position: Int) {

        holder.name.text = playerName[position]
        holder.info.text = playerCountry[position]
        holder.img.setImageResource(playerImage[position])
        holder.img2.setImageResource(playerTeamImage[position])

/*      holder.img.setImageResource(R.drawable.shadab)
        holder.img2.setImageResource(R.drawable.pakistan)
        holder.name.text = "Shadab Khan"
        holder.info.text = "Pakistan"*/
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img : ImageView
        var img2 : ImageView
        var name : TextView
        var info : TextView

        init {
            img = itemView.findViewById(R.id.iv_img)
            img2 = itemView.findViewById(R.id.iv_img2)
            name = itemView.findViewById(R.id.tv_name)
            info = itemView.findViewById(R.id.tv_info)
        }
    }
}