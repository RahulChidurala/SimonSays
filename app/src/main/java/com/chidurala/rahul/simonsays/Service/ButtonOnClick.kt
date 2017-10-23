package com.chidurala.rahul.simonsays.Service

import android.content.Context
import android.widget.Button
import org.jetbrains.anko.runOnUiThread
import java.util.*
import kotlin.concurrent.schedule

/**
* Created by Rahul Chidurala on 10/4/2017.
*/
class ButtonOnClick(private val context: Context, private val buttonLighter: ButtonLighter, private val buttonId: Int, private val buttonInputService: ButtonInputService) {

    companion object {
        var enabled: Boolean = true
    }

    private val timer: Timer = Timer()

    fun userOnClick() {

        if(ButtonOnClick.enabled) {

            buttonLighter.lightUp()
        }
    }

    fun userOnRelease() {

        if(ButtonOnClick.enabled) {

            buttonInputService.addInput(buttonId)
            buttonLighter.darkenButton()
        }
    }

    fun automaticOnClick() {

        buttonLighter.lightUp()

        timer.schedule(delay = DifficultyService.difficultyService.getSpeed()) {

            context.runOnUiThread {
                buttonLighter.darkenButton()
            }
        }
    }
}