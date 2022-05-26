package com.ehb.cricket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.R
import com.ehb.cricket.classes.Matches

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

   private var matchName = arrayOf("PAK vs IND", "PAK vs BAN","AUS vs PAK", "PAK vs ENG","WI vs PAK","PAK vs IND", "PAK vs BAN","AUS vs PAK", "PAK vs ENG","WI vs PAK")
   private var imgTeam1 = arrayOf(R.drawable.pakistan, R.drawable.pakistan, R.drawable.australia, R.drawable.pakistan,R.drawable.west_indies,R.drawable.pakistan, R.drawable.pakistan, R.drawable.australia, R.drawable.pakistan,R.drawable.west_indies)
   private var imgTeam2 = arrayOf(R.drawable.india, R.drawable.bangladesh, R.drawable.pakistan, R.drawable.england,R.drawable.pakistan,R.drawable.india, R.drawable.bangladesh, R.drawable.pakistan, R.drawable.england,R.drawable.pakistan)
   private var matchDateAndTime = arrayOf("28-05-2022, 5PM", "28-05-2022, 5PM","28-05-2022, 5PM", "28-05-2022, 5PM","28-05-2022, 5PM","28-05-2022, 5PM", "28-05-2022, 5PM","28-05-2022, 5PM", "28-05-2022, 5PM","28-05-2022, 5PM")

   // lateinit var matchName: List<Matches>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return matchName.size
    }

    override fun onBindViewHolder(holder: MatchAdapter.ViewHolder, position: Int) {

        // holder.name.text = matchName[position].name
        holder.name.text = matchName[position]
        holder.dateAndTime.text = matchDateAndTime[position]
        holder.img1.setImageResource(imgTeam1[position])
        holder.img2.setImageResource(imgTeam2[position])
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img1 : ImageView
        var img2 : ImageView
        var name : TextView
        var dateAndTime : TextView

        init {
            img1 = itemView.findViewById(R.id.iv_img)
            img2 = itemView.findViewById(R.id.iv_img2)
            name = itemView.findViewById(R.id.tv_name)
            dateAndTime = itemView.findViewById(R.id.tv_info)
        }
    }
}