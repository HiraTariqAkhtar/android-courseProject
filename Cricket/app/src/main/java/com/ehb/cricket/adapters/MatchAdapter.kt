package com.ehb.cricket.adapters

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.Favourites
import com.ehb.cricket.R
import com.ehb.cricket.classes.Countries
import com.ehb.cricket.classes.Matches
import com.ehb.cricket.classes.Players

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {
    val fav_match_list = arrayListOf<Matches>(Matches("gug", R.drawable.cricket, R.drawable.india), Matches("azertyu", R.drawable.shadab, R.drawable.pakistan))

   private var matchName = arrayOf("PAK vs IND", "PAK vs BAN","AUS vs PAK", "PAK vs ENG","WI vs PAK","PAK vs IND", "PAK vs BAN","AUS vs PAK", "PAK vs ENG","WI vs PAK")
   private var imgTeam1 = arrayOf(R.drawable.pakistan, R.drawable.pakistan, R.drawable.australia, R.drawable.pakistan,R.drawable.west_indies,R.drawable.pakistan, R.drawable.pakistan, R.drawable.australia, R.drawable.pakistan,R.drawable.west_indies)
   private var imgTeam2 = arrayOf(R.drawable.india, R.drawable.bangladesh, R.drawable.pakistan, R.drawable.england,R.drawable.pakistan,R.drawable.india, R.drawable.bangladesh, R.drawable.pakistan, R.drawable.england,R.drawable.pakistan)
   private var matchDateAndTime = arrayOf("28-05-2022, 5PM", "28-05-2022, 5PM","28-05-2022, 5PM", "28-05-2022, 5PM","28-05-2022, 5PM","28-05-2022, 5PM", "28-05-2022, 5PM","28-05-2022, 5PM", "28-05-2022, 5PM","28-05-2022, 5PM")

    // extra information match
   private var matchType = arrayOf("ODI", "T20i","Test - Day 4", "ODI","ODI","ODI", "T20i","Test - Day 4", "ODI","ODI")
   private var venue = arrayOf("Gadaffi stadium, Lahore", "Dubai International Cricket Stadium","Adelaide Oval, Australia", "Melbourne Cricket Ground","Gadaffi stadium, Lahore", "Dubai International Cricket Stadium","Adelaide Oval, Australia", "Melbourne Cricket Ground")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        val viewholder = ViewHolder(v)

        val detailPage =Dialog(parent.context, R.style.dialog)
        detailPage.setContentView(R.layout.activity_match_detail)

        viewholder.match.setOnClickListener {
            val team1 = detailPage.findViewById<ImageView>(R.id.team1)
            val team2 = detailPage.findViewById<ImageView>(R.id.team2)
            val teams = detailPage.findViewById<TextView>(R.id.name)
            val dateTime = detailPage.findViewById<TextView>(R.id.dateAndTime)
            val type = detailPage.findViewById<TextView>(R.id.matchType)
            val location = detailPage.findViewById<TextView>(R.id.venueName)

            val backbtn = detailPage.findViewById<Button>(R.id.backBtn)
            val favbtn = detailPage.findViewById<Button>(R.id.addToFav)
            val removeFav = detailPage.findViewById<TextView>(R.id.removeFav)
            val favPage = Favourites()

            team1.setImageResource(imgTeam1[viewholder.adapterPosition])
            team2.setImageResource(imgTeam2[viewholder.adapterPosition])
            teams.text = matchName[viewholder.adapterPosition]
            dateTime.text = matchDateAndTime[viewholder.adapterPosition]
            type.text = matchType[viewholder.adapterPosition]
            location.text = venue[viewholder.adapterPosition]

            backbtn.setOnClickListener {
                detailPage.dismiss()
            }

            favbtn.setOnClickListener {
                val addMatch = Matches(matchName[viewholder.adapterPosition],imgTeam1[viewholder.adapterPosition],imgTeam2[viewholder.adapterPosition])
                fav_match_list.add(addMatch)

                favbtn.visibility = View.GONE
                removeFav.visibility = View.VISIBLE

//                Toast.makeText(parent.context, favPage.matchList.toString(), Toast.LENGTH_SHORT).show()
            }

            removeFav.setOnClickListener {
                val removeMatch = Matches(matchName[viewholder.adapterPosition], imgTeam1[viewholder.adapterPosition], imgTeam2[viewholder.adapterPosition])
                fav_match_list.remove(removeMatch)

                removeFav.visibility = View.GONE
                favbtn.visibility = View.VISIBLE

//                Toast.makeText(parent.context, favPage.matchList.toString(), Toast.LENGTH_SHORT).show()
            }
            


            detailPage.show()
        }


        return viewholder
    }


    override fun getItemCount(): Int {
        return matchName.size
    }

    override fun onBindViewHolder(holder: MatchAdapter.ViewHolder, position: Int) {

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
        val match : CardView

        init {
            img1 = itemView.findViewById(R.id.iv_img)
            img2 = itemView.findViewById(R.id.iv_img2)
            name = itemView.findViewById(R.id.tv_name)
            dateAndTime = itemView.findViewById(R.id.tv_info)
            match = itemView.findViewById(R.id.card_view)
        }
    }
}