package com.timzowen.theandroidseries

import com.timzowen.theandroidseries.data.allWords as gameWords

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

/**
 * Finds the unscrambled word by matching the characters of the scrambled word.
 */
internal fun getUnscrambledWord(scrambledWord: String): String {
    return gameWords.first { word ->
        word.length == scrambledWord.length &&
                word.toCharArray().sortedArray().contentEquals(scrambledWord.toCharArray().sortedArray())
    }
}