package com.chidurala.rahul.simonsays.Service

import android.app.AlertDialog
import android.util.Log
import com.chidurala.rahul.simonsays.Delegate.GameOverDelegate

/**
 * Created by Rahul Chidurala on 10/7/2017.
 *
 */
class GameLeveler {

    private var gameSequenceGenerator: GameSequenceGenerator
    private var gameSequencePlayer: GameSequencePlayer
    private val gameOverDelegate: GameOverDelegate?

    private val livesPerGame: Int
    var lives: Int
    private var sequence: Sequence

    constructor(lives: Int, gameSequenceGenerator: GameSequenceGenerator, gameSequencePlayer: GameSequencePlayer, gameOverDelegate: GameOverDelegate? = null) {

        this.livesPerGame = lives
        this.lives = lives
        this.gameSequenceGenerator = gameSequenceGenerator
        this.gameSequencePlayer = gameSequencePlayer
        this.gameOverDelegate = gameOverDelegate

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

            // TODO: Game over!
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