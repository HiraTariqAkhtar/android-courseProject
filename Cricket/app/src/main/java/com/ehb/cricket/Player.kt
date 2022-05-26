package com.ehb.cricket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ehb.cricket.adapters.MatchAdapter
import com.ehb.cricket.adapters.PlayerAdapter

class Player : Fragment() {

    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: RecyclerView.Adapter<PlayerAdapter.ViewHolder>
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(activity)

        recyclerView = view.findViewById(R.id.player_rv)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        adapter = PlayerAdapter()
        recyclerView.adapter = adapter

    }

}