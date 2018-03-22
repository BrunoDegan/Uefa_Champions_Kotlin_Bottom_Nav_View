package com.degan.uefaleague.fragments
import com.degan.uefaleague.adapters.GamesAdapter
import com.degan.uefaleague.database.Database
import kotlinx.android.synthetic.main.games_list.*

class LibertadoresFragment : AbstractFragment() {
    companion object {
        @JvmField
        val championship_name = "Libertadores"
    }

    override fun onStart() {
        super.onStart()
        recyclerview_games.adapter = GamesAdapter(activity = activity,
                gamesList = Database.getLibertadoresGames())
    }
}