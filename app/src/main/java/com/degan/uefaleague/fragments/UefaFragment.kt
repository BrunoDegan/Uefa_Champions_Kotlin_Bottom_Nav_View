package com.degan.uefaleague.fragments
import android.support.v4.app.SupportActivity
import com.degan.uefaleague.adapters.GamesAdapter
import com.degan.uefaleague.database.Database
import kotlinx.android.synthetic.main.games_list.*

class UefaFragment : AbstractFragment() {
    companion object {
        @JvmField
        val championship_name = "UEFA Champions League"
    }

    override fun onStart() {
        super.onStart()
        recyclerview_games.adapter = GamesAdapter(activity = activity,
                gamesList = Database.getUefaGames())
    }
}