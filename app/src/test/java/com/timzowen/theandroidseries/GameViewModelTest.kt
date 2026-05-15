package com.timzowen.theandroidseries

import androidx.lifecycle.viewmodel.compose.viewModel
import com.timzowen.theandroidseries.data.MAX_NO_WORDS
import com.timzowen.theandroidseries.data.SCORE_INCREASE
import com.timzowen.theandroidseries.ui.GameViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_correctGuess_updateScore() {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value

        assertFalse(currentGameUiState.isGuessedWordWrong)
        assertEquals(SCORE_AFTER_CORRECT_ANSWER, currentGameUiState.score)
    }

    @Test
    fun gameViewModel_incorrectGuess_ErrorFlagDisplayed() {
        val incorrectPlayerWord = "and"
        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()

        val currentGameUiState = viewModel.uiState.value
        assertTrue(currentGameUiState.isGuessedWordWrong)
        assertEquals(0, currentGameUiState.score)
    }

    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {
        val gameUiState = viewModel.uiState.value
        val unScrambledWord = getUnscrambledWord(gameUiState.currentScrambledWord)
        assertNotEquals(unScrambledWord, gameUiState.currentScrambledWord)
        assertTrue(gameUiState.currentWordCount == 1)
        assertFalse(gameUiState.isGuessedWordWrong)
        assertFalse(gameUiState.isGameOver)
    }

    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly() {
        var expectedCount = 0
        var currentGameUiState = viewModel.uiState.value
        var correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        repeat(MAX_NO_OF_WORDS) {
            expectedCount += SCORE_INCREASE
            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()
            currentGameUiState = viewModel.uiState.value
            correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
            assertEquals(expectedCount, currentGameUiState.score)
        }
        assertEquals(MAX_NO_OF_WORDS, currentGameUiState.currentWordCount)
        assertTrue(currentGameUiState.isGameOver)
    }

    @Test
    fun gameViewModel_WordSkipped_ScoreUnchangedAndNextWordLoaded() {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        val lastWordCount = currentGameUiState.currentWordCount
        val scoreAfterFirstCorrectAnswer = currentGameUiState.score

        viewModel.skipWord()
        currentGameUiState = viewModel.uiState.value

        assertEquals(scoreAfterFirstCorrectAnswer, currentGameUiState.score)
        assertEquals(lastWordCount + 1, currentGameUiState.currentWordCount)
    }

    @Test
    fun gameViewModel_ResetGame_UiStateReset() {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        assertTrue(currentGameUiState.score > 0)
        assertTrue(currentGameUiState.currentWordCount > 1)

        viewModel.resetGame()
        currentGameUiState = viewModel.uiState.value

        assertEquals(0, currentGameUiState.score)
        assertEquals(1, currentGameUiState.currentWordCount)
        assertFalse(currentGameUiState.isGameOver)
        assertFalse(currentGameUiState.isGuessedWordWrong)
    }

    companion object {
        private const val SCORE_AFTER_CORRECT_ANSWER = SCORE_INCREASE
    }


}