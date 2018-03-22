package com.degan.uefaleague.domain
import android.os.Parcel
import android.os.Parcelable

class Team (val name : String,
            val idBadge: Int,
            val idFlag : Int,
            val championship: Int) : Parcelable {

    override fun describeContents(): Int {
        return 0
    }

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt())

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeInt(idBadge)
        dest?.writeInt(idFlag)
        dest?.writeInt(championship)
    }


    companion object  {
        @JvmField
        val TEAM_KEY = "team_key"

        @JvmField
        val CREATOR : Parcelable.Creator<Team> = object : Parcelable.Creator<Team>{

            override fun createFromParcel(source_parcel: Parcel): Team {
                return Team(source_parcel)
            }

            override fun newArray(size: Int): Array<Team?> {
                return arrayOfNulls(size)
            }
        }
    }

}