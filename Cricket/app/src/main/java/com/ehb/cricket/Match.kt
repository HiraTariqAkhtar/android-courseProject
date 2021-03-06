package com.ehb.cricket

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.adapters.MatchAdapter
import com.ehb.cricket.classes.Matches
import com.ehb.cricket.services.MatchService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Match : Fragment() {

    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: RecyclerView.Adapter<MatchAdapter.ViewHolder>
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(activity)

        recyclerView = view.findViewById(R.id.match_rv)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        adapter = MatchAdapter()
        recyclerView.adapter = adapter
/*
        // retrofit

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.cricapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(MatchService::class.java)
        api.getMatches().enqueue(object: Callback<List<Matches>>{
            override fun onResponse(call: Call<List<Matches>>, response: Response<List<Matches>>) {
                if (!response.isSuccessful){
                    d("match", response.code().toString())
                    return
                }
                var matchList: List<Matches>? = response.body()
                adapter = MatchAdapter()
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Matches>>, t: Throwable) {
                d("match", t.toString())
            }
        })*/

    }

}