package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        return countCombinations(array[0], array[1])
    }

    private fun colorCombinations(countColor: Int, countCombinations: Int): Int {
        val factorialCountColor = factorial(countColor)
        val factorialCountCombinations = factorial(countCombinations)
        val factorialDifferences = factorial(countColor - countCombinations)
        return (factorialCountColor / (factorialCountCombinations * factorialDifferences)).toInt()
    }

    private fun factorial(n: Int): Long {
        return if (n != 1) {
            n * factorial(n - 1)
        } else 1
    }

    private fun countCombinations(poster: Int, color: Int): Int? {
        if (poster == 0 || color == 0) return null
        for (i in 1 until color) {
            val number = colorCombinations(color, i)
            if (number >= poster) return i
        }
        return null
    }
}

