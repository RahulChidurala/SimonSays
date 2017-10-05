package com.chidurala.rahul.simonsays.Service

import android.content.Context
import android.util.Log
import com.chidurala.rahul.simonsays.Model.GameBoard
import org.jetbrains.anko.runOnUiThread
import java.util.*
import kotlin.concurrent.schedule

/**
 * Created by Rahul Chidurala on 10/5/2017.
 */
class GameSequencePlayer {

    private val context: Context
    private val gameBoard: GameBoard

    private val timer: Timer
    constructor(context: Context, gameBoard: GameBoard) {

        this.context = context
        this.gameBoard = gameBoard
        timer = Timer()
    }

    fun playSequence(sequence: Sequence) {

        var iterator: Long = 0
        for (buttonIndex in sequence) {

            iterator++
            val scheduledTime: Long = (iterator * 1000)
            Log.d("DEBUG", "Button: " + buttonIndex)
            val button = gameBoard.buttons[buttonIndex]
            timer.schedule(scheduledTime) {

                context.runOnUiThread {

                    button.callOnClick()
                }
            }
        }
    }
}