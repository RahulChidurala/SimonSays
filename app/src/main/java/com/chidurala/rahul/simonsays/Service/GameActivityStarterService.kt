package com.chidurala.rahul.simonsays.Service

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.chidurala.rahul.simonsays.Activity.GameActivity
import com.chidurala.rahul.simonsays.Model.Difficulty

/**
 * Created by Rahul Chidurala on 10/17/2017.
 */
class GameActivityStarterService {

    private val context: Context

    constructor(context: Context) {

        this.context = context
    }

    fun startGame(difficulty: Difficulty) {

        val intent = Intent(context, GameActivity::class.java)
        intent.putExtra("difficulty", difficulty)
        startGame(intent)
    }

    private fun startGame(intent: Intent) {

        context.startActivity(intent)
    }
}