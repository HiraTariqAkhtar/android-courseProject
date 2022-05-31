package com.ehb.cricket.adapters

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.Favourites
import com.ehb.cricket.Player
import com.ehb.cricket.PlayerDetail
import com.ehb.cricket.R
import com.ehb.cricket.SQLite_database.Database
import com.ehb.cricket.classes.Matches
import com.ehb.cricket.classes.Players

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {
    val fav_player_list = arrayListOf<Players>(Players("Shadab Khan", R.drawable.shadab, R.drawable.pakistan))

    private var playerName = arrayOf("Shadab Khan", "Virat Kohli","Shadab Khan", "Virat Kohli","Shadab Khan", "Virat Kohli","Shadab Khan", "Virat Kohli","Shadab Khan", "Virat Kohli")
    private var playerCountry = arrayOf("Pakistan", "India","Pakistan", "India", "Pakistan", "India", "Pakistan", "India", "Pakistan", "India")
    private var playerImage = arrayOf(R.drawable.shadab, R.drawable.kohli, R.drawable.shadab, R.drawable.kohli,R.drawable.shadab, R.drawable.kohli,R.drawable.shadab, R.drawable.kohli,R.drawable.shadab, R.drawable.kohli)
    private var playerTeamImage = arrayOf(R.drawable.pakistan, R.drawable.india, R.drawable.pakistan, R.drawable.india,R.drawable.pakistan, R.drawable.india,R.drawable.pakistan, R.drawable.india,R.drawable.pakistan, R.drawable.india)

    // player details
    private var playerDOB = arrayOf("04-10-1998", "05-11-1988","04-10-1998", "05-11-1988","04-10-1998", "05-11-1988","04-10-1998", "05-11-1988","04-10-1998", "05-11-1988")
    private var playerPOB = arrayOf("Mianwali, Pakistan", "Delhi, India","Mianwali, Pakistan", "Delhi, India","Mianwali, Pakistan", "Delhi, India","Mianwali, Pakistan", "Delhi, India","Mianwali, Pakistan", "Delhi, India")
    private var playerRole = arrayOf("Allrounder", "Batsman","Allrounder", "Batsman","Allrounder", "Batsman","Allrounder", "Batsman","Allrounder", "Batsman")
    private var playerBatStyle = arrayOf("Right handed bat", "Right handed bat","Right handed bat", "Right handed bat","Right handed bat", "Right handed bat","Right handed bat", "Right handed bat","Right handed bat", "Right handed bat")
    private var playerBowlStyle = arrayOf("Right-arm legbreak", "Right-arm medium","Right-arm legbreak", "Right-arm medium","Right-arm legbreak", "Right-arm medium","Right-arm legbreak", "Right-arm medium","Right-arm legbreak", "Right-arm medium")

    @SuppressLint("Range")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        val viewholder = ViewHolder(v)

        val nextPage = Dialog(parent.context, R.style.dialog)
        nextPage.setContentView(R.layout.activity_player_detail)


        viewholder.player.setOnClickListener {
        //    d("player", "clicked" + viewholder.adapterPosition.toString())

            val pic = nextPage.findViewById<ImageView>(R.id.imageView)
            val namePlayer = nextPage.findViewById<TextView>(R.id.name)
            val countryName = nextPage.findViewById<TextView>(R.id.countryName)
            val date = nextPage.findViewById<TextView>(R.id.date)
            val place = nextPage.findViewById<TextView>(R.id.place)
            val roleInfo = nextPage.findViewById<TextView>(R.id.roleInfo)
            val bowlingStyle = nextPage.findViewById<TextView>(R.id.bowlingStyle)
            val battingStyle = nextPage.findViewById<TextView>(R.id.battingStyle)

            val backbtn = nextPage.findViewById<Button>(R.id.backBtn)
            val favbtn = nextPage.findViewById<Button>(R.id.addToFav)
            val removeFav = nextPage.findViewById<TextView>(R.id.removeFav)
            val favPage = Favourites()

            // show correct details in dialog
            pic.setImageResource(playerImage[viewholder.adapterPosition])
            namePlayer.text = playerName[viewholder.adapterPosition]
            countryName.text = playerCountry[viewholder.adapterPosition]
            date.text = playerDOB[viewholder.adapterPosition]
            place.text = playerPOB[viewholder.adapterPosition]
            roleInfo.text = playerRole[viewholder.adapterPosition]
            bowlingStyle.text = playerBowlStyle[viewholder.adapterPosition]
            battingStyle.text = playerBatStyle[viewholder.adapterPosition]

            backbtn.setOnClickListener {
            //   Toast.makeText(parent.context, "button clicked!!", Toast.LENGTH_SHORT).show()
                nextPage.dismiss()
            }

            favbtn.setOnClickListener {
                val addedPlayer = Players(playerName[viewholder.adapterPosition], playerImage[viewholder.adapterPosition], playerTeamImage[viewholder.adapterPosition])
                fav_player_list.add(addedPlayer)

                favbtn.visibility = View.GONE
                removeFav.visibility = View.VISIBLE

                // below we have created
                // a new Database class,
                // and passed context to it
                val db = Database(parent.context, null)

                // calling method to add
                // name to our database
                db.addFav(playerName[viewholder.adapterPosition], playerImage[viewholder.adapterPosition], playerTeamImage[viewholder.adapterPosition])


            //  Toast.makeText(parent.context, favPage.playerList.toString(), Toast.LENGTH_SHORT).show()
            }

            removeFav.setOnClickListener {
                val removedPlayer = Players(playerName[viewholder.adapterPosition], playerImage[viewholder.adapterPosition], playerTeamImage[viewholder.adapterPosition])
                fav_player_list.remove(removedPlayer)

                removeFav.visibility = View.GONE
                favbtn.visibility = View.VISIBLE
            }

            nextPage.show()
        }

        return viewholder
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
        val player : CardView
        var img : ImageView
        var img2 : ImageView
        var name : TextView
        var info : TextView

        init {
            img = itemView.findViewById(R.id.iv_img)
            img2 = itemView.findViewById(R.id.iv_img2)
            name = itemView.findViewById(R.id.tv_name)
            info = itemView.findViewById(R.id.tv_info)
            player = itemView.findViewById(R.id.card_view)
        }
    }
}