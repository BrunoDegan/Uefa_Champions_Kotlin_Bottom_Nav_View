package com.degan.uefaleague.domain

import android.os.Parcel

import android.os.Parcelable
class Game(val homeTeam : Team,
           val awayTeam : Team,
           val stadium: String,
           val date: String,
           val gameTime: String) : Parcelable {

    companion object {
        @JvmField
        val TEAM_KEY = "game_key"

        @JvmField
        val CREATOR: Parcelable.Creator<Game> = object : Parcelable.Creator<Game> {
            override fun createFromParcel(source_parcel: Parcel): Game {
                return Game(source_parcel)
            }

            override fun newArray(size: Int): Array<Game?> {
                return arrayOfNulls(size)
            }
        }

    }

    constructor(parcel: Parcel) : this(
            parcel.readParcelable<Team>(Team::class.java.classLoader),
            parcel.readParcelable<Team>(Team::class.java.classLoader),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(homeTeam, 0)
        parcel.writeParcelable(awayTeam, 0)
        parcel.writeString(stadium)
        parcel.writeString(date)
        parcel.writeString(gameTime)
    }

    override fun describeContents(): Int {
        return 0
    }
}
