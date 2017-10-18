package com.chidurala.rahul.simonsays.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import com.chidurala.rahul.simonsays.Controller.GameController
import com.chidurala.rahul.simonsays.Model.Difficulty
import com.chidurala.rahul.simonsays.R
import com.chidurala.rahul.simonsays.Service.ButtonOnClick
import com.chidurala.rahul.simonsays.View.FourSquareView

class GameActivity : AppCompatActivity() {

    private lateinit var gameController: GameController
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)

        val rootViewGroup: ViewGroup = findViewById(R.id.game_area)
        startButton = findViewById(R.id.btn_start)
        startButton.setOnClickListener {

            actionStart()
        }

        val difficulty = intent.extras.get("difficulty") as? Difficulty

        when(difficulty) {

            Difficulty.easy -> ButtonOnClick.delay = 500
            Difficulty.medium -> ButtonOnClick.delay = 350
            Difficulty.hard -> ButtonOnClick.delay = 200
        }

        val fourSquareView = FourSquareView(this, viewGroup = rootViewGroup)

        gameController = GameController(this, fourSquareView)
    }

    private fun actionStart() {

        gameController.startGame()
    }

    override fun finish() {
        super.finish()

        Log.d("DEBUG", "")
    }
}
