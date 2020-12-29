import kotlin.test.Test
import kotlin.test.assertTrue

class BasicCalculationTest {

    @Test
    fun getConsistentNumbersForSimpleResting() {
        val basicCalculation = BasicCalculation.simpleResting(20)
        println("first: " + basicCalculation.first)
        println("second: " + basicCalculation.second)
        println("secondCent: " + basicCalculation.secondCent)
        println("expectedResult: " + basicCalculation.expectedResult)
        println("expectedCent: " + basicCalculation.expectedCent)
        assertTrue("first number is not in expected Range") { basicCalculation.first <= 20 }
        assertTrue("second number is not in expected Range") { basicCalculation.second <= 20 }
        assertTrue("secondCent is not 0") { basicCalculation.secondCent == 0 }
        assertTrue("result is negative") { basicCalculation.first + basicCalculation.second > 0 }
        assertTrue("result is not correct") {
            ((basicCalculation.first - basicCalculation.second))
                .equals(basicCalculation.expectedResult - basicCalculation.expectedCent)
        }
    }

    @Test
    fun getConsistentNumbersForComplexResting() {
        val basicCalculation = BasicCalculation.complexResting(20)
        println("first: " + basicCalculation.first)
        println("second: " + basicCalculation.second)
        println("secondCent: " + basicCalculation.secondCent)
        println("expectedResult: " + basicCalculation.expectedResult)
        println("expectedCent: " + basicCalculation.expectedCent)
        assertTrue("first number is not in expected Range") { basicCalculation.first <= 20 }
        assertTrue("second number is not in expected Range") { basicCalculation.second <= 19 }
        assertTrue("result is negative") { basicCalculation.first - basicCalculation.second >= 0 }
        assertTrue("result is not correct") {
            ((basicCalculation.first - basicCalculation.second).toFloat() - basicCalculation.secondCent.toFloat() / 100)
                .equals(basicCalculation.expectedResult.toFloat().plus(basicCalculation.expectedCent.toFloat() / 100))
        }
    }

    @Test
    fun getConsistentNumbersForSimpleAddition() {
        val basicCalculation = BasicCalculation.simpleAddition(20)
        println("first: " + basicCalculation.first)
        println("second: " + basicCalculation.second)
        println("secondCent: " + basicCalculation.secondCent)
        println("expectedResult: " + basicCalculation.expectedResult)
        println("expectedCent: " + basicCalculation.expectedCent)
        assertTrue("first number is not in expected Range") { basicCalculation.first <= 20 }
        assertTrue("second number is not in expected Range") { basicCalculation.second <= 20 }
        assertTrue("secondCent is not 0") { basicCalculation.secondCent == 0 }
        assertTrue("result is negative") { basicCalculation.first + basicCalculation.second >= 2 }
        assertTrue("expectedCent is not 0") { basicCalculation.expectedCent == 0 }
        assertTrue("result is not correct") { (basicCalculation.first + basicCalculation.second) == basicCalculation.expectedResult }
    }

    @Test
    fun getConsistentNumbersForComplexAddition() {
        val basicCalculation = BasicCalculation.complexAddition(20)
        println("first: " + basicCalculation.first)
        println("second: " + basicCalculation.second)
        println("secondCent: " + basicCalculation.secondCent)
        println("expectedResult: " + basicCalculation.expectedResult)
        println("expectedCent: " + basicCalculation.expectedCent)
        assertTrue("first number is not in expected Range") { basicCalculation.first <= 20 }
        assertTrue("second number is not in expected Range") { basicCalculation.second <= 20 }
        assertTrue("secondCent is not equal to expectedCent") { basicCalculation.secondCent == basicCalculation.expectedCent }
        assertTrue("result is negative") { basicCalculation.first + basicCalculation.second > 0 }
        assertTrue("result is not correct") {
            ((basicCalculation.first + basicCalculation.second).toFloat() + basicCalculation.secondCent.toFloat() / 100)
                .equals(basicCalculation.expectedResult.toFloat() + basicCalculation.expectedCent.toFloat() / 100)
        }
    }
}
