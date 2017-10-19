package com.chidurala.rahul.simonsays.Service

import com.chidurala.rahul.simonsays.Model.Difficulty

/**
* Created by Rahul Chidurala on 10/18/2017.
*/
class DifficultyService {

    companion object {

        val difficultyService: DifficultyService = DifficultyService()
    }

    private var speed: Long = 500

    fun setDifficulty(difficulty: Difficulty) {

        when(difficulty) {

            Difficulty.easy -> speed = 500
            Difficulty.medium -> speed = 350
            Difficulty.hard -> speed = 200
        }
    }

    fun getSpeed(): Long {

        return speed
    }
}