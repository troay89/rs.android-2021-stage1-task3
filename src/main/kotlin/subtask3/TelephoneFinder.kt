package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.toInt() < 0) return null
        val result = mutableListOf<String>()
        for ((index, n) in number.withIndex()) {
            val litters = change(n)
            if (litters != null) {
                for (litter in litters) {
                    val newNumber = number.replaceRange(index, index + 1, litter.toString())
                    result.add(newNumber)
                }
            }
        }
        println(result)
        return result.toTypedArray()
    }

    private fun change(number: Char) = when (number) {
        '1' -> listOf('2', '4')
        '2' -> listOf('1', '3', '5')
        '3' -> listOf('2', '6')
        '4' -> listOf('1', '5', '7')
        '5' -> listOf('2','4','6', '8')
        '6' -> listOf('3', '5', '9')
        '7' -> listOf('4', '8')
        '8' -> listOf('7', '5', '9', '0')
        '9' -> listOf('6', '8')
        '0' -> listOf('8')
        else -> null
    }
}

fun main() {
    val phone = TelephoneFinder()
    phone.findAllNumbersFromGivenNumber("5")
}
