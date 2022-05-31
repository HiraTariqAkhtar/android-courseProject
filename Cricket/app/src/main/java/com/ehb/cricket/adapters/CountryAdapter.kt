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

class CountryAdapter  : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    val fav_country_list = arrayListOf<Countries>(Countries("Pakistan", R.drawable.pak_flag, R.drawable.pakistan), Countries("Australia", R.drawable.aus_flag, R.drawable.australia), Countries("India", R.drawable.in_flag, R.drawable.india))

    private var countryName = arrayOf("Pakistan", "India","Australia", "England","West Indies","Bangladesh")
    private var countryFlag = arrayOf(R.drawable.pak_flag, R.drawable.in_flag, R.drawable.aus_flag, R.drawable.eng_flag, R.drawable.wi_flag, R.drawable.ban_flag)
    private var countryImage = arrayOf(R.drawable.pakistan, R.drawable.india, R.drawable.australia, R.drawable.england, R.drawable.west_indies, R.drawable.bangladesh)


    // extra details national team
    private var captainTest = arrayOf("Babar Azam", "Rohit Sharma","Pat Cummins", "Ben Stokes","Kraigg Brathwaite","Mominul Haque")
    private var captainODI = arrayOf("Babar Azam", "Rohit Sharma","Aaron Finch", "Eoin Morgan","Nicholas Pooran","Tamim Iqbal")
    private var captainT20 = arrayOf("Babar Azam", "Rohit Sharma","Aaron Finch", "Eoin Morgan","Nicholas Pooran","Mahmudullah")

    private var first_test = arrayOf("vs India: 16-18/10/1952", "vs England: 25-28/06/1932", "vs England: 15-19/03/1877", "vs Australia: 15-19/03/1877", "vs England: 23-26/06/1928", "vs India: 10-13/11/2000")
    private var first_odi = arrayOf("vs New-Zealand: 11/02/1973", "vs England: 13/07/1974", "vs England: 05/01/1971", "vs Australia: 05/01/1971", "vs England: 05/09/1973", "vs Pakistan: 31/03/1986")
    private var first_t20 = arrayOf("vs England: 28/08/2006", "vs South Africa: 01/12/2006", "vs New-Zealand: 17/02/2005", "vs Australia: 05/01/1971", "vs New-Zealand: 16/02/2006", "vs Zimbabwe: 28/11/2006")



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        val vh = ViewHolder(v)

        val details = Dialog(parent.context, R.style.dialog)
        details.setContentView(R.layout.activity_country_detail)

        vh.country.setOnClickListener {

            val teamImg = details.findViewById<ImageView>(R.id.teamImg)
            val country_name = details.findViewById<TextView>(R.id.name)
            val test_captain = details.findViewById<TextView>(R.id.captainTestName)
            val odi_captain = details.findViewById<TextView>(R.id.captainODIName)
            val t20_captain = details.findViewById<TextView>(R.id.captainT20Name)
            val first_test_match = details.findViewById<TextView>(R.id.firstTestMatch)
            val first_odi_match = details.findViewById<TextView>(R.id.firstODIMatch)
            val first_t20_match = details.findViewById<TextView>(R.id.firstT20Match)

            val backbtn = details.findViewById<Button>(R.id.backBtn)
            val favbtn = details.findViewById<Button>(R.id.addToFav)
            val removeFav = details.findViewById<TextView>(R.id.removeFav)
            val favPage = Favourites()

            teamImg.setImageResource(countryImage[vh.adapterPosition])
            country_name.text = countryName[vh.adapterPosition]
            test_captain.text = captainTest[vh.adapterPosition]
            odi_captain.text = captainODI[vh.adapterPosition]
            t20_captain.text = captainT20[vh.adapterPosition]
            first_test_match.text = first_test[vh.adapterPosition]
            first_odi_match.text = first_odi[vh.adapterPosition]
            first_t20_match.text = first_t20[vh.adapterPosition]

            backbtn.setOnClickListener {
                details.dismiss()
            }

            favbtn.setOnClickListener {
                val addedCountry = Countries(countryName[vh.adapterPosition], countryImage[vh.adapterPosition], countryFlag[vh.adapterPosition])
                fav_country_list.add(addedCountry)

                favbtn.visibility = View.GONE
                removeFav.visibility = View.VISIBLE

            }

            removeFav.setOnClickListener {
                val removedCountry = Countries(countryName[vh.adapterPosition], countryImage[vh.adapterPosition], countryFlag[vh.adapterPosition])

                removeFav.visibility = View.GONE
                favbtn.visibility = View.VISIBLE


            }

            details.show()
        }

        return vh
    }


    override fun getItemCount(): Int {
        return countryName.size
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {

        holder.name.text = countryName[position]
        holder.name.textSize = 25F
        holder.img1.setImageResource(countryFlag[position])
        holder.img2.setImageResource(countryImage[position])
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img1 : ImageView
        var img2 : ImageView
        var name : TextView
        val country : CardView

        init {
            img1 = itemView.findViewById(R.id.iv_img)
            img2 = itemView.findViewById(R.id.iv_img2)
            name = itemView.findViewById(R.id.tv_name)
            country = itemView.findViewById(R.id.card_view)
        }
    }
}