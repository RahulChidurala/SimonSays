package com.chidurala.rahul.simonsays.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.chidurala.rahul.simonsays.Controller.MainMenuController
import com.chidurala.rahul.simonsays.R
import com.chidurala.rahul.simonsays.View.MainMenuView

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val menuArea: ViewGroup = findViewById(R.id.menu_area)

        val mainMenu = MainMenuView(this, menuArea)

         MainMenuController(this, mainMenu)
    }
}
