package com.chidurala.rahul.simonsays.Delegate

import com.chidurala.rahul.simonsays.Service.Sequence

/**
 * Created by Rahul Chidurala on 10/8/2017.
 */
interface UserInputDelegate {

    fun userInputCompleted(userInputSequence: Sequence)
    fun userInput(userInputSequence: Sequence)
}