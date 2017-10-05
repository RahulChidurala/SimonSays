package com.chidurala.rahul.simonsays

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.chidurala.rahul.simonsays.Controller.GameController
import com.chidurala.rahul.simonsays.View.FourSquareView

class MainActivity : AppCompatActivity() {

    private lateinit var gameController: GameController
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val rootViewGroup: ViewGroup = findViewById(R.id.game_area)
        startButton = findViewById(R.id.btn_start)
        startButton.setOnClickListener {

            actionStart()
        }

        val fourSquareView = FourSquareView(this, viewGroup = rootViewGroup)

        gameController = GameController(this, fourSquareView)
    }

    private fun actionStart() {

        gameController.startGame()
    }
}
