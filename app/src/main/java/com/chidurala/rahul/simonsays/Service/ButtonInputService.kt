package com.chidurala.rahul.simonsays.Service

import android.widget.Button
import com.chidurala.rahul.simonsays.Delegate.UserInputCompletedDelegate

/**
 * Created by Rahul Chidurala on 10/8/2017.
 */
class ButtonInputService {

    private val userInputCompletedDelegate: UserInputCompletedDelegate
    private var correctSequence: Sequence

    private var userInputSequence: Sequence
    private var userInputLimit: Int

    constructor(userInputCompletedDelegate: UserInputCompletedDelegate, correctSequence: Sequence) {

        this.userInputCompletedDelegate = userInputCompletedDelegate
        this.correctSequence = correctSequence

        userInputSequence = Sequence()
        userInputLimit = 1
    }

    fun setCorrectSequence(sequence: Sequence) {

        correctSequence = sequence
    }

    fun addInput(buttonId: Int) {

        userInputSequence.add(buttonId)

        if(userInputSequence.count() == correctSequence.count()) {

            userInputCompletedDelegate.userInputCompleted(userInputSequence)
            userInputSequence = Sequence()
        }
    }
}