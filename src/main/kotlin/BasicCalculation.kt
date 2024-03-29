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

        fun simpleHighRangeAddition(maxNumber: Int): BasicCalculation {
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

        fun simpleMultiplication(maxNumberFirst: Int, maxNumberSecond: Int): BasicCalculation {
            val first = Random.nextInt(1, maxNumberFirst)
            val second = Random.nextInt(1, maxNumberSecond)
            return BasicCalculation(first, second, 0, first * second, 0, "x")
        }

        fun simpleDivision(maxNumberForFactors: Int): BasicCalculation {

            val firstFactor = Random.nextInt(1, maxNumberForFactors)
            val secondFactor = Random.nextInt(1, maxNumberForFactors)
            return BasicCalculation(firstFactor * secondFactor, secondFactor, 0, firstFactor, 0, ":")
        }
    }
}
