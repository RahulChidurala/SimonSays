package com.chidurala.rahul.simonsays.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.chidurala.rahul.simonsays.R

/**
 * Created by Rahul Chidurala on 10/17/2017.
 */
class MainMenuView : View {

    val btn_easy: Button
    val btn_medium: Button
    val btn_hard: Button

    constructor(context: Context, viewGroup: ViewGroup) : super(context) {

        val view = LayoutInflater.from(context).inflate(R.layout.main_menu, viewGroup)

        btn_easy = view.findViewById(R.id.btn_easy)
        btn_medium = view.findViewById(R.id.btn_medium)
        btn_hard = view.findViewById(R.id.btn_hard)
    }

}