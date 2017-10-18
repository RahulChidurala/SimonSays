package com.chidurala.rahul.simonsays.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.chidurala.rahul.simonsays.Model.GameBoard
import com.chidurala.rahul.simonsays.R

/**
 * Created by chrah on 10/3/2017.
 */

class FourSquareView : View, GameBoard {

    override var buttons: ArrayList<Button>

    constructor(context: Context, viewGroup: ViewGroup) : super(context) {

        val view = LayoutInflater.from(context).inflate(R.layout.four_square, viewGroup)

        val redButton: Button = view.findViewById(R.id.btn_red)
        val blueButton: Button = view.findViewById(R.id.btn_blue)
        val yellowButton: Button = view.findViewById(R.id.btn_yellow)
        val greenButton: Button = view.findViewById(R.id.btn_green)

        buttons = ArrayList<Button>()
        buttons.add(redButton)
        buttons.add(blueButton)
        buttons.add(yellowButton)
        buttons.add(greenButton)
    }
}