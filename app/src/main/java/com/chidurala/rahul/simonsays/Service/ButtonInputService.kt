package com.chidurala.rahul.simonsays.Service

import com.chidurala.rahul.simonsays.Delegate.UserInputDelegate

/**
 * Created by Rahul Chidurala on 10/8/2017.
 */
class ButtonInputService {

    private val userInputDelegate: UserInputDelegate
    private var correctSequence: Sequence

    private var userInputSequence: Sequence
    private var userInputLimit: Int

    constructor(userInputDelegate: UserInputDelegate, correctSequence: Sequence) {

        this.userInputDelegate = userInputDelegate
        this.correctSequence = correctSequence

        userInputSequence = Sequence()
        userInputLimit = 1
    }

    fun setCorrectSequence(sequence: Sequence) {

        correctSequence = sequence
    }

    fun addInput(buttonId: Int) {

        userInputSequence.add(buttonId)

        userInputDelegate.userInput(userInputSequence)

        if(userInputSequence.count() == correctSequence.count()) {

            userInputDelegate.userInputCompleted(userInputSequence)
            userInputSequence = Sequence()
        }
    }
}