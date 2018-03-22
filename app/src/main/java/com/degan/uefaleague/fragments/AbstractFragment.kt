package com.degan.uefaleague.fragments

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.degan.uefaleague.R
import kotlinx.android.synthetic.main.games_list.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AbstractFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AbstractFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
abstract class AbstractFragment : android.app.Fragment() {

    var recyclerViewStateParcel: Parcelable ? = null

    companion object {
        @JvmField val KEY = "Key"
        @JvmField val TITLE = "Title"
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.games_list,container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerview_games.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(activity)
        recyclerview_games.layoutManager = layoutManager

        val divider = DividerItemDecoration(activity, layoutManager.orientation)
        recyclerview_games.addItemDecoration(divider)

        recoverState()
    }

    private fun recoverState() {
        recyclerViewStateParcel = recyclerview_games.layoutManager.onSaveInstanceState()
    }

    override fun onPause() {
        super.onPause()
        recoverState()
    }

    override fun onResume() {
        super.onResume()
        recyclerview_games.layoutManager.onRestoreInstanceState(recyclerViewStateParcel)
    }
}
