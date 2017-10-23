package com.chidurala.rahul.simonsays.Controller

import android.content.Context
import android.util.EventLog
import android.util.Log
import android.view.MotionEvent
import com.chidurala.rahul.simonsays.Delegate.GameOverDelegate
import com.chidurala.rahul.simonsays.Delegate.UserInputDelegate
import com.chidurala.rahul.simonsays.Model.GameBoard
import com.chidurala.rahul.simonsays.Service.*
import com.chidurala.rahul.simonsays.Service.Sequence
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk25.coroutines.onTouch

/**
* Created by Rahul Chidurala on 10/4/2017.
*/
class GameController(private val context: Context, gameBoard: GameBoard) : UserInputDelegate, GameOverDelegate {

    private val buttonLighters: ArrayList<ButtonLighter>
    private var buttonOnClicks: ButtonOnClicks = ButtonOnClicks()
    private val gameLeveler: GameLeveler
    private val gameSequenceChecker: GameSequenceChecker

    private val  gameSequenceGenerator: GameSequenceGenerator
    private val buttonInputService: ButtonInputService

    fun startGame() {

        gameLeveler.startGame()
    }

    private fun nextLevel() {

        gameLeveler.levelCleared()
        buttonInputService.setCorrectSequence(gameSequenceGenerator.getCurrentSequence())
    }

    private fun wrongSequence() {

        gameLeveler.levelFailed()
    }

    override fun userInputCompleted(userInputSequence: Sequence) {

        if(gameLeveler.lives > 0) {

            val correct = gameSequenceChecker.checkSequence(gameSequenceGenerator.getCurrentSequence(), userInputSequence)

            if(correct) {

                nextLevel()

            } else {

                wrongSequence()
            }
        }
    }

    override fun userInput(userInputSequence: Sequence) {

        if(gameLeveler.lives > 0) {

            val correct = gameSequenceChecker.checkSequence(gameSequenceGenerator.getCurrentSequence(), userInputSequence)

            if(!correct) {

                wrongSequence()
            }
        }
    }

    override fun gameOver() {

        context.alert("Game over! Your score is: " + gameSequenceGenerator.getCurrentSequence().count()) {

            title = "Simon Says"
            positiveButton("Restart!") {

                gameLeveler.startGame()
            }

            negativeButton("OK") {
                // Do nothing
            }
        }.show()

        gameSequenceGenerator.resetSequence()
    }

    init {
        buttonLighters = ArrayList()
        val buttonCount = gameBoard.buttons.count()
        gameSequenceGenerator = GameSequenceGenerator(gameBoard = gameBoard)
        buttonInputService = ButtonInputService(this, gameSequenceGenerator.getCurrentSequence())
        for (buttonIndex in 0..buttonCount-1) {

            val button = gameBoard.buttons[buttonIndex]
            val buttonLighter = ButtonLighter(button)
            buttonLighters.add(buttonLighter)
            buttonLighter.darkenButton()
            val buttonOnClick = ButtonOnClick(context, buttonLighter, buttonIndex, buttonInputService)
            buttonOnClicks.add(buttonOnClick)

            button.onTouch { v, event ->

                if(event.action == MotionEvent.ACTION_DOWN) {

                    buttonOnClick.userOnClick()

                } else if(event.action == MotionEvent.ACTION_UP) {

                    buttonOnClick.userOnRelease()
                }
            }
        }
        val gameSequencePlayer = GameSequencePlayer(context, buttonOnClicks)
        gameLeveler = GameLeveler(3, gameSequenceGenerator, gameSequencePlayer, this)
        gameSequenceChecker = GameSequenceChecker()
    }
}