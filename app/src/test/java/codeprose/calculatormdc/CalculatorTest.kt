package codeprose.calculatormdc

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalculatorTest {
    @Test
    fun isCorrect() {
        val epsilon = 1e-7
        assertEquals(4.0, Calculator.solve("2 + 2"),epsilon)
        assertEquals(42.0, Calculator.solve("7 * 6"),epsilon)
        assertEquals(8.0, Calculator.solve("2 + 2 * 3"),epsilon)
    }
}
