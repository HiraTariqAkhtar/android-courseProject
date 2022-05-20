package com.ehb.cricket

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ehb.cricket.classes.Matches
import com.ehb.cricket.services.MatchService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Match : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.cricapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(MatchService::class.java)
        api.getMatches().enqueue(object: Callback<List<Matches>>{
            override fun onResponse(call: Call<List<Matches>>, response: Response<List<Matches>>) {
                d("match", "onResponse")
            }

            override fun onFailure(call: Call<List<Matches>>, t: Throwable) {
                d("match", "onFailure")
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

}