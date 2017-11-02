package com.chidurala.rahul.simonsays.Delegate

import android.widget.TextView

/**
 * Created by Rahul Chidurala on 10/23/2017.
 */
interface DisplayInfoDelegate {

    var display: TextView
    fun showInfo(info: String)
}