package com.chidurala.rahul.simonsays.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.chidurala.rahul.simonsays.Controller.GameController
import com.chidurala.rahul.simonsays.Delegate.DisplayInfoDelegate
import com.chidurala.rahul.simonsays.Model.Difficulty
import com.chidurala.rahul.simonsays.R
import com.chidurala.rahul.simonsays.Service.ButtonOnClick
import com.chidurala.rahul.simonsays.Service.DifficultyService
import com.chidurala.rahul.simonsays.View.FourSquareView

class GameActivity : AppCompatActivity(), DisplayInfoDelegate {

    private lateinit var gameController: GameController
    private lateinit var startButton: Button
    private lateinit var lbl_displayLives: TextView

    override lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)

        val rootViewGroup: ViewGroup = findViewById(R.id.game_area)
        startButton = findViewById(R.id.btn_start)
        lbl_displayLives = findViewById(R.id.lbl_lives)
        display = lbl_displayLives

        startButton.setOnClickListener {

            actionStart()
        }

        val difficulty = intent.extras.get("difficulty") as? Difficulty

        if(difficulty != null) {

            DifficultyService.difficultyService.setDifficulty(difficulty)
        }

        val fourSquareView = FourSquareView(this, viewGroup = rootViewGroup)

        gameController = GameController(this, fourSquareView)
        gameController.displayLives = this
    }

    override fun showInfo(info: String) {

        display.setText(info)
    }

    private fun actionStart() {

        gameController.startGame()
    }

    override fun finish() {
        super.finish()

        Log.d("DEBUG", "")
    }
}
