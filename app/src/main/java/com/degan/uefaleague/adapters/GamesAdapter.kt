package com.degan.uefaleague.adapters

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.degan.uefaleague.R
import com.degan.uefaleague.activities.DetailsNameActivity
import com.degan.uefaleague.domain.Game
import com.degan.uefaleague.domain.Team

class GamesAdapter(val activity : Activity, val gamesList : List<Game>) :
        RecyclerView.Adapter<GamesAdapter.ViewHolder>() {


    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var llTc: LinearLayout
        var ivHomeCountryFlag: ImageView
        var ivHomeShieldFlag: ImageView
        var tvHomeCountryName: TextView

        /* Time visitante */
        var llTv: LinearLayout
        var ivCountryFlag: ImageView
        var ivCountryShield: ImageView
        var tvCountryName: TextView

        var tvData: TextView
        var tvHorario: TextView
        var tvEstadio: TextView

        init {
            llTc = itemView.findViewById(R.id.ll_tc)
            llTc.setOnClickListener(this)
            ivHomeCountryFlag = itemView.findViewById(R.id.iv_tc_bandeira_pais)
            ivHomeShieldFlag = itemView.findViewById(R.id.iv_tc_escudo)
            tvHomeCountryName = itemView.findViewById(R.id.tv_tc_nome)

            llTv = itemView.findViewById(R.id.ll_tv)
            llTv.setOnClickListener(this)
            ivCountryFlag = itemView.findViewById(R.id.iv_tv_bandeira_pais)
            ivCountryShield = itemView.findViewById(R.id.iv_tv_escudo)
            tvCountryName = itemView.findViewById(R.id.tv_tv_nome)

            tvData = itemView.findViewById(R.id.tv_data)
            tvHorario = itemView.findViewById(R.id.tv_horario)
            tvEstadio = itemView.findViewById(R.id.tv_estadio)
        }


        override fun onClick(view: View?) {
            val intent = Intent(activity, DetailsNameActivity::class.java)
            intent.putExtra(Team.TEAM_KEY, view!!.tag as Team)
            activity.startActivity(intent)
        }


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    }

    override fun getItemCount(): Int {
    }


}