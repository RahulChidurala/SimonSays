package com.chidurala.rahul.simonsays.Service

import android.content.Context
import org.jetbrains.anko.runOnUiThread
import java.util.*
import kotlin.concurrent.schedule

/**
 * Created by Rahul Chidurala on 10/4/2017.
 */
class ButtonOnClick {

    private companion object {
        var enabled: Boolean = true
    }

    private val context: Context
    private val buttonLighter: ButtonLighter
    private val timer: Timer

    private val delay: Long = 500

    constructor(context: Context, buttonLighter: ButtonLighter) {

        this.context = context
        this.buttonLighter = buttonLighter
        timer = Timer()
    }

    fun onClick() {

        if(ButtonOnClick.enabled) {

            ButtonOnClick.enabled = false
            buttonLighter.lightUp()

            timer.schedule(delay = delay) {

                context.runOnUiThread {
                    buttonLighter.darkenButton()
                }
                ButtonOnClick.enabled = true
            }
        }
    }
}