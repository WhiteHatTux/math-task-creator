import kotlin.random.Random

class BasicCalculation(var first: Int, var second: Int, var secondCent: Int, var expectedResult: Int, var expectedCent: Int, var operator: String) {

    companion object Factory {
        fun simpleResting(maxNumber: Int): BasicCalculation {
            val firstTemp = Random.nextInt(1, maxNumber)
            val secondTemp = Random.nextInt(1, maxNumber)
            val first: Int
            val second: Int
            when {
                firstTemp == secondTemp -> {
                    first = firstTemp
                    second = secondTemp - 1
                }
                firstTemp > secondTemp -> {
                    first = firstTemp
                    second = secondTemp
                }
                else -> {
                    first = secondTemp
                    second = firstTemp
                }
            }

            return BasicCalculation(
                first, second, 0, first - second, 0, "-"
            )
        }

        fun complexResting(maxNumber: Int): BasicCalculation {
            val firstTemp = Random.nextInt(1, maxNumber)
            val secondTemp = Random.nextInt(1, maxNumber)
            val secondCent = Random.nextInt(0, 99)
            val first: Int
            val second: Int
            when {
                firstTemp == secondTemp -> {
                    first = firstTemp
                    second = secondTemp - 1
                }
                firstTemp > secondTemp -> {
                    first = firstTemp
                    second = secondTemp
                }
                else -> {
                    first = secondTemp
                    second = firstTemp
                }
            }

            val expectedResult = if (secondCent == 0) {
                first - second
            } else {
                first - second - 1
            }
            return BasicCalculation(
                first, second, secondCent, expectedResult, 100 - secondCent, "-"
            )
        }

        fun simpleAddition(maxNumber: Int): BasicCalculation {
            val first = Random.nextInt(1, maxNumber)
            val second = Random.nextInt(1, maxNumber)

            return BasicCalculation(first, second, 0, first + second, 0, "+")
        }

        fun complexAddition(maxNumber: Int): BasicCalculation {
            val first = Random.nextInt(1, maxNumber)
            val second = Random.nextInt(1, maxNumber - 1)
            val cent = Random.nextInt(1, 99)

            return BasicCalculation(first, second, cent, first + second, cent, "+")
        }
    }
}
