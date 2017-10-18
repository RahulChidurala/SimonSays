package com.chidurala.rahul.simonsays.Service

/**
 * Created by Rahul Chidurala on 10/7/2017.
 */
class GameSequenceChecker {

    /**
     * Checks if the input sequence matches the correctSequence so far
     */
    fun checkSequence(correctSequence: Sequence, inputSequence: Sequence): Boolean {

        var correct = true
        val correctSequenceCount = correctSequence.count()
        val inputSequenceCount = inputSequence.count()

        if(inputSequenceCount > correctSequenceCount) {

            // More inputs than the correct sequence
            return false
        }

        for (index in 0..inputSequenceCount-1) {

            if(correctSequence[index] != inputSequence[index]) {

                correct = false
                break
            }
        }

        return correct
    }
}