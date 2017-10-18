package com.chidurala.rahul.simonsays.Controller

import android.content.Context
import com.chidurala.rahul.simonsays.Delegate.GameOverDelegate
import com.chidurala.rahul.simonsays.Delegate.UserInputDelegate
import com.chidurala.rahul.simonsays.Model.GameBoard
import com.chidurala.rahul.simonsays.Service.*
import com.chidurala.rahul.simonsays.Service.Sequence
import org.jetbrains.anko.alert

/**
 * Created by Rahul Chidurala on 10/4/2017.
 */
class GameController: UserInputDelegate, GameOverDelegate {

    private val context: Context
    private val gameBoard: GameBoard
    private val buttonLighters: ArrayList<ButtonLighter>
    private var buttonOnClicks: ButtonOnClicks = ButtonOnClicks()
    private val gameLeveler: GameLeveler
    private val gameSequenceChecker: GameSequenceChecker

    private val  gameSequenceGenerator: GameSequenceGenerator
    private val buttonInputService: ButtonInputService

    constructor(context: Context, gameBoard: GameBoard) {

        this.context = context
        this.gameBoard = gameBoard
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

            button.setOnClickListener {

                buttonOnClick.userOnClick()
            }
        }

        val gameSequencePlayer = GameSequencePlayer(context, buttonOnClicks)
        gameLeveler = GameLeveler(3, gameSequenceGenerator, gameSequencePlayer, this)
        gameSequenceChecker = GameSequenceChecker()
    }

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

    override fun userInputCompleted(sequence: Sequence) {

        if(gameLeveler.lives > 0) {

            val correct = gameSequenceChecker.checkSequence(gameSequenceGenerator.getCurrentSequence(), sequence)

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
}