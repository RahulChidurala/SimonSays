package com.chidurala.rahul.simonsays.Controller

import android.content.Context
import android.content.Intent
import com.chidurala.rahul.simonsays.Activity.GameActivity
import com.chidurala.rahul.simonsays.Model.Difficulty
import com.chidurala.rahul.simonsays.Service.GameActivityStarterService
import com.chidurala.rahul.simonsays.View.MainMenuView
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

/**
 * Created by Rahul Chidurala on 10/17/2017.
 */
class MainMenuController {

    private var context: Context

    private val gameActivityStarterService: GameActivityStarterService

    constructor(context: Context, mainMenuView: MainMenuView) {

        this.context = context

        gameActivityStarterService = GameActivityStarterService(context)

        mainMenuView.btn_easy.setOnClickListener { actionEasy() }
        mainMenuView.btn_medium.setOnClickListener { actionMedium() }
        mainMenuView.btn_hard.setOnClickListener { actionHard() }
    }

    fun actionEasy() {

        gameActivityStarterService.startGame(Difficulty.easy)
    }

    fun actionMedium() {

        gameActivityStarterService.startGame(Difficulty.medium)
    }

    fun actionHard() {

        gameActivityStarterService.startGame(Difficulty.hard)
    }
}