package com.chidurala.rahul.simonsays.Service

import android.graphics.Color
import android.widget.Button
import android.graphics.drawable.ColorDrawable


/**
 * Created by Rahul Chidurala on 10/4/2017.
 */
class ButtonLighter {

    private val darkeningFactor = 0.5f

    private val button: Button
    private val lightColor: Int
    private val darkColor: Int

    constructor(button: Button) {

        this.button = button
        lightColor = getColor()
        darkColor = getDarkColor()
    }

    fun lightUp() {

        button.setBackgroundColor(lightColor)
    }

    fun darkenButton() {

        button.setBackgroundColor(darkColor)
    }

    private fun getColor(): Int {

        val colorDrawable = (button.background) as ColorDrawable
        return colorDrawable.color
    }

    private fun getDarkColor(): Int {

        val hsv = FloatArray(3)
        val colorDrawable = (button.background) as ColorDrawable
        var color = colorDrawable.color
        Color.colorToHSV(color, hsv)

        hsv[2] *= darkeningFactor

        color = Color.HSVToColor(hsv)
        return color.toInt()
    }
}