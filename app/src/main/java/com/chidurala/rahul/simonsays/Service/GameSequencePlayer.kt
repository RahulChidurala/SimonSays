package com.chidurala.rahul.simonsays.Service

import android.content.Context
import android.util.Log
import android.widget.Button
import com.chidurala.rahul.simonsays.Model.GameBoard
import org.jetbrains.anko.runOnUiThread
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

/**
* Created by Rahul Chidurala on 10/5/2017.
*/

typealias ButtonOnClicks = ArrayList<ButtonOnClick>

class GameSequencePlayer(private val context: Context, private val buttonOnClicks: ButtonOnClicks) {

    private val timer: Timer = Timer()

    fun playSequence(sequence: Sequence) {

        var iterator: Int = 0
        var buttonClickEnablerIterator: Int = 0
        val sequenceCount = sequence.count()
        if(sequenceCount > 0) {

            ButtonOnClick.enabled = false
        }

        for (buttonIndex in sequence) {

            iterator++
            val scheduledTime: Long = (iterator * DifficultyService.difficultyService.getSpeed() * 2)
            Log.d("DEBUG", "Button: " + buttonIndex)
            val buttonOnClick = buttonOnClicks[buttonIndex]
            timer.schedule(scheduledTime) {

                context.runOnUiThread {

                    buttonOnClick.automaticOnClick()

                    buttonClickEnablerIterator++
                    Log.d("DEBUG", "iterator: " + buttonClickEnablerIterator + ", sequenceCount: " + sequenceCount)
                    if(buttonClickEnablerIterator == sequenceCount) {

                        ButtonOnClick.enabled = true
                    }
                }
            }
        }
    }

}