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

   private var matchName = arrayOf("PAK vs IND", "PAK vs BAN","PAK vs AUS", "PAK vs ENG","PAK vs SA","PAK vs IND", "PAK vs BAN","PAK vs AUS", "PAK vs ENG","PAK vs SA")
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
        holder.img.setImageResource(R.drawable.cricket)
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img : ImageView
        var name : TextView

        init {
            img = itemView.findViewById(R.id.iv_match)
            name = itemView.findViewById(R.id.tv_match)
        }
    }
}