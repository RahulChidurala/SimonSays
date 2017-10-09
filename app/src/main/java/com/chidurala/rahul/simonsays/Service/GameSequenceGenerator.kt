package com.chidurala.rahul.simonsays.Service

import com.chidurala.rahul.simonsays.Model.GameBoard
import java.util.*
import kotlin.collections.ArrayList

/**
* Created by Rahul Chidurala on 10/5/2017.
*/

typealias Sequence = ArrayList<Int>

class GameSequenceGenerator {

    private val buttonCount: Int
    private var sequenceStartCount: Int

    private val random: Random
    private var sequence: Sequence

    private val sequenceIncrementer = 1

    constructor(gameBoard: GameBoard, sequenceStartCount: Int = 0) {

        buttonCount = gameBoard.buttons.count()
        this.sequenceStartCount = sequenceStartCount

        random = Random()
        sequence = Sequence()

        createSequence(sequenceStartCount)
    }

    fun getCurrentSequence(): Sequence {

        return sequence
    }

    /**
     * Increments the previous sequence and returns the sequence.
     * @return ArrayList<Int> representing button indexes
     */
    fun getNewSequence(): Sequence {

        addToSequence()

        return sequence
    }

    fun resetSequence() {

        sequence.clear()
        createSequence(1)
    }

    /**
     * For starting with a sequence
     */
    private fun createSequence(sequenceCount: Int) {

        for (i in 1..sequenceCount) {

            addToSequence()
        }
    }

    private fun addToSequence() {

        val nextInt = random.nextInt(buttonCount)
        sequence.add(nextInt)
        sequenceStartCount += sequenceIncrementer
    }
}