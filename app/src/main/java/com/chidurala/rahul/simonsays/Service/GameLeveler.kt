package com.chidurala.rahul.simonsays.Service

import android.app.AlertDialog
import android.util.Log
import com.chidurala.rahul.simonsays.Delegate.DisplayInfoDelegate
import com.chidurala.rahul.simonsays.Delegate.GameOverDelegate

/**
 * Created by Rahul Chidurala on 10/7/2017.
 *
 */
class GameLeveler(private var gameSequenceGenerator: GameSequenceGenerator, private var gameSequencePlayer: GameSequencePlayer, private val gameOverDelegate: GameOverDelegate? = null, private val totalLives: Int = 3) {

    private var _lives: Int = totalLives

    var lives: Int
        get() = _lives
        set(value) {

            _lives = value
            displayLives?.showInfo(value.toString())
        }

    private val livesPerGame: Int = lives
    private var sequence: Sequence

    // TODO: Remove display lives delegate from here
    var displayLives: DisplayInfoDelegate? = null

    init {
        this.lives = lives
        sequence = gameSequenceGenerator.getNewSequence()
    }

    fun startGame() {
        
        lives = livesPerGame
        gameSequenceGenerator.resetSequence()
        sequence = gameSequenceGenerator.getCurrentSequence()
        gameSequencePlayer.playSequence(sequence)
    }

    /**
     * Level cleared. Reset lives, increment sequence and play new sequence.
     */
    fun levelCleared() {

        sequence = gameSequenceGenerator.getNewSequence()
        playLevel(sequence)
    }

    /**
     * Level failed. Implement later...
     */
    fun levelFailed() {

        lives--

        if(lives <= 0) {

            Log.d("GAME", "Game over!")
            gameOver()

        } else {

            playLevel(sequence = sequence)
        }
    }

    private fun gameOver() {

        gameOverDelegate?.gameOver()
    }

    private fun playLevel(sequence: Sequence) {

        gameSequencePlayer.playSequence(sequence)
    }
}