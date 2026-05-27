package com.timzowen.theandroidseries.ui

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RaceParticipantTest {

    private val raceParticipant = RaceParticipant(
        name = "Test Player",
        maxProgress = 100,
        progressDelayMillis = 500L,
        progressIncrement = 1
    )

    @Test
    fun raceParticipant_InitialProgressIsZero() {
        assertEquals(0, raceParticipant.currentProgress)
    }

    @Test
    fun raceParticipant_RaceFinished_ProgressUpdated() = runTest {
        raceParticipant.run()
        assertEquals(100, raceParticipant.currentProgress)
    }

    @Test
    fun raceParticipant_ProgressUpdatedAfterDelay() = runTest {
        val player = RaceParticipant(
            name = "Test Player",
            maxProgress = 100,
            progressDelayMillis = 500L
        )
        launch { player.run() }
        advanceTimeBy(player.progressDelayMillis)
        // Ensure that the coroutine has a chance to execute the line after delay
        runCurrent()
        assertEquals(1, player.currentProgress)
    }

    @Test
    fun raceParticipant_Reset_ProgressIsZero() = runTest {
        raceParticipant.run()
        raceParticipant.reset()
        assertEquals(0, raceParticipant.currentProgress)
    }

    @Test(expected = IllegalArgumentException::class)
    fun raceParticipant_InvalidMaxProgress_ThrowsException() {
        RaceParticipant(name = "Invalid", maxProgress = 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun raceParticipant_InvalidProgressIncrement_ThrowsException() {
        RaceParticipant(name = "Invalid", progressIncrement = 0)
    }
}
