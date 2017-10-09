package com.chidurala.rahul.simonsays.Service

import android.content.Context
import android.widget.Button
import org.jetbrains.anko.runOnUiThread
import java.util.*
import kotlin.concurrent.schedule

/**
 * Created by Rahul Chidurala on 10/4/2017.
 */
class ButtonOnClick {

    public companion object {
        var enabled: Boolean = true
    }

    private val context: Context
    private val buttonLighter: ButtonLighter
    private val buttonId: Int
    private val buttonInputService: ButtonInputService

    private val timer: Timer
    private val delay: Long = 500

    constructor(context: Context, buttonLighter: ButtonLighter, buttonId: Int, buttonInputService: ButtonInputService) {

        this.context = context
        this.buttonLighter = buttonLighter
        this.buttonId = buttonId
        this.buttonInputService = buttonInputService

        timer = Timer()
    }

    fun userOnClick() {

        if(ButtonOnClick.enabled) {

            ButtonOnClick.enabled = false
            buttonLighter.lightUp()
            buttonInputService.addInput(buttonId)

            timer.schedule(delay = delay) {

                context.runOnUiThread {
                    buttonLighter.darkenButton()
                }
                ButtonOnClick.enabled = true
            }
        }
    }

    fun automaticOnClick() {

        buttonLighter.lightUp()

        timer.schedule(delay = delay) {

            context.runOnUiThread {
                buttonLighter.darkenButton()
            }
        }
    }
}