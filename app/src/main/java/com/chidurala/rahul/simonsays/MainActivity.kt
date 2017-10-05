package com.chidurala.rahul.simonsays

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.chidurala.rahul.simonsays.Controller.GameController
import com.chidurala.rahul.simonsays.View.FourSquareView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val rootViewGroup: ViewGroup = findViewById(android.R.id.content)
        val fourSquareView = FourSquareView(this, viewGroup = rootViewGroup)

        val gameController = GameController(this, fourSquareView)
    }
}
