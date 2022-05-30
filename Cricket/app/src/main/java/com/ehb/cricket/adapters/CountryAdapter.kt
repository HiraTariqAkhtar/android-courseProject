package com.ehb.cricket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.R

class CountryAdapter  : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    private var countryName = arrayOf("Pakistan", "India","Australia", "England","West Indies","Bangladesh")
    private var countryFlag = arrayOf(R.drawable.pak_flag, R.drawable.in_flag, R.drawable.aus_flag, R.drawable.eng_flag, R.drawable.wi_flag, R.drawable.ban_flag)
    private var countryImage = arrayOf(R.drawable.pakistan, R.drawable.india, R.drawable.australia, R.drawable.england, R.drawable.west_indies, R.drawable.bangladesh)


    // extra details national team
    private var captainTest = arrayOf("Babar Azam", "Rohit Sharma","Pat Cummins", "Ben Stokes","Kraigg Brathwaite","Mominul Haque")
    private var captainODI = arrayOf("Babar Azam", "Rohit Sharma","Aaron Finch", "Eoin Morgan","Nicholas Pooran","Tamim Iqbal")
    private var captainT20 = arrayOf("Babar Azam", "Rohit Sharma","Aaron Finch", "Eoin Morgan","Nicholas Pooran","Mahmudullah")

    private var first_est = arrayOf("vs India: 16-18/10/1952", "vs England: 25-28/06/1932", "vs England: 15-19/03/1877", "vs Australia: 15-19/03/1877", "vs England: 23-26/06/1928", "vs India: 10-13/11/2000")
    private var first_odi = arrayOf("vs New-Zealand: 11/02/1973", "vs England: 13/07/1974", "vs England: 05/01/1971", "vs Australia: 05/01/1971", "vs England: 05/09/1973", "vs Pakistan: 31/03/1986")
    private var first_t20 = arrayOf("vs England: 28/08/2006", "vs South Africa: 01/12/2006", "vs New-Zealand: 17/02/2005", "vs Australia: 05/01/1971", "vs New-Zealand: 16/02/2006", "vs Zimbabwe: 28/11/2006")



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
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

        init {
            img1 = itemView.findViewById(R.id.iv_img)
            img2 = itemView.findViewById(R.id.iv_img2)
            name = itemView.findViewById(R.id.tv_name)
        }
    }
}