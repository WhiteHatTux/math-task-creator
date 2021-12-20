import kotlin.test.Test
import kotlin.test.assertEquals
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
        assertEquals(
            basicCalculation.expectedResult - basicCalculation.expectedCent,
            ((basicCalculation.first - basicCalculation.second)),
            "result is not correct"
        )
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
        assertTrue("second number is not in expected Range") { basicCalculation.second <= 20 }
        assertTrue("result is negative") { basicCalculation.first - basicCalculation.second >= 0 }
        assertEquals(
            basicCalculation.expectedResult.toFloat().plus(basicCalculation.expectedCent.toFloat() / 100),
            ((basicCalculation.first - basicCalculation.second).toFloat() - basicCalculation.secondCent.toFloat() / 100),
            "result is not correct."
        )
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
        assertEquals(basicCalculation.expectedResult, basicCalculation.first + basicCalculation.second, "result is not correct")
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
        assertEquals(
            basicCalculation.expectedResult.toFloat() + basicCalculation.expectedCent.toFloat() / 100,
            ((basicCalculation.first + basicCalculation.second).toFloat() + basicCalculation.secondCent.toFloat() / 100),
            "result is not correct"
        )
    }

    @Test
    fun getConsistentNumbersForSimpleMultiplication() {
        val basicCalculation = BasicCalculation.simpleMultiplication(10, 10)
        println("first: " + basicCalculation.first)
        println("second: " + basicCalculation.second)
        println("secondCent: " + basicCalculation.secondCent)
        println("expectedResult: " + basicCalculation.expectedResult)
        println("expectedCent: " + basicCalculation.expectedCent)
        assertTrue("first number is not in expected Range") { basicCalculation.first <= 10 }
        assertTrue("second number is not in expected Range") { basicCalculation.second <= 10 }
        assertTrue("result is negative") { basicCalculation.first * basicCalculation.second in 1..100 }
        assertEquals(basicCalculation.first * basicCalculation.second, basicCalculation.expectedResult, "result is not correct")
    }

    @Test
    fun getConsistentNumbersForSimpleDivision() {
        val basicCalculation = BasicCalculation.simpleDivision(10)
        println("first: " + basicCalculation.first)
        println("second: " + basicCalculation.second)
        println("secondCent: " + basicCalculation.secondCent)
        println("expectedResult: " + basicCalculation.expectedResult)
        println("expectedCent: " + basicCalculation.expectedCent)
        assertTrue("first number is not in expected Range") { basicCalculation.first <= 100 }
        assertTrue("second number is not in expected Range") { basicCalculation.second <= 10 }
        assertEquals(basicCalculation.first / basicCalculation.second, basicCalculation.expectedResult, "result is not correct")
    }
}
