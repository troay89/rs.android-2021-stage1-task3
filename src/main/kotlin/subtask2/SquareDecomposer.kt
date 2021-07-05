package subtask2

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val result = mutableListOf<Int>()
        var tempPown = number * number
        var sq = 0
        var element = number - 1
        do {
            result.add(element)
            tempPown -= element * element
            if (tempPown == 0)
                return result.reversed().toTypedArray()
            if (element == 1) {
                if (result.size < 2) {
                    break
                }
                tempPown += result[result.lastIndex] * result[result.lastIndex]
                result.removeAt(result.lastIndex)
                element = result[result.lastIndex] - 1
                tempPown += result[result.lastIndex] * result[result.lastIndex]
                result.removeAt(result.lastIndex)
            } else {
                sq = kotlin.math.sqrt(tempPown.toFloat()).toInt()
                if (element <= sq) {
                    element--
                } else {
                    element = sq
                }
            }
        } while (element > 0)
        return null
    }
}