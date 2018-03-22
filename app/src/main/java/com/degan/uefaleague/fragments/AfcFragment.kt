package com.degan.uefaleague.fragments

import com.degan.uefaleague.adapters.GamesAdapter
import com.degan.uefaleague.database.Database
import kotlinx.android.synthetic.main.games_list.*

class AfcFragment : AbstractFragment() {
    companion object {
        @JvmField
        val championship_name = "Afc"
    }

    override fun onStart() {
        super.onStart()
        recyclerview_games.adapter = GamesAdapter(activity = activity,
                gamesList = Database.getAFCGames())
    }
}
