package com.chidurala.rahul.simonsays.Service

/**
 * Created by Rahul Chidurala on 10/7/2017.
 */
class GameSequenceChecker {

    fun checkSequence(correctSequence: Sequence, inputSequence: Sequence): Boolean {

        var correct = true
        val correctSequenceCount = correctSequence.count()
        val inputSequenceCount = inputSequence.count()

        if(correctSequenceCount != inputSequenceCount) {

            return false
        }

        for (index in 0..correctSequenceCount-1) {

            if(correctSequence[index] != inputSequence[index]) {

                correct = false
                break
            }
        }

        return correct
    }
}