package com.chidurala.rahul.simonsays.Controller

import android.content.Context
import com.chidurala.rahul.simonsays.Model.GameBoard
import com.chidurala.rahul.simonsays.Service.ButtonLighter
import com.chidurala.rahul.simonsays.Service.ButtonOnClick

/**
 * Created by Rahul Chidurala on 10/4/2017.
 */
class GameController {

    private val context: Context
    private val gameBoard: GameBoard
    private val buttonLighters: ArrayList<ButtonLighter>

    constructor(context: Context, gameBoard: GameBoard) {

        this.context = context
        this.gameBoard = gameBoard
        buttonLighters = ArrayList()
        for(button in gameBoard.buttons) {

            val buttonLighter = ButtonLighter(button)
            buttonLighters.add(buttonLighter)
            buttonLighter.darkenButton()
            val buttonOnClick = ButtonOnClick(context, buttonLighter)

            button.setOnClickListener {

                buttonOnClick.onClick()
            }
        }
    }
}