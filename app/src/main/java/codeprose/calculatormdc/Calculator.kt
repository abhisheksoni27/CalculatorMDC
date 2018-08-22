package codeprose.calculatormdc

/**
 * Adapted with changes from GeeksForGeeks: https://www.geeksforgeeks.org/expression-evaluation/
 */

import java.util.*

class Calculator {
    companion object {
        fun solve(expression: String): Double {
            val tokens = expression.toCharArray()

            // Stack for numbers: 'values'
            val values = Stack<Double>()

            // Stack for Operators: 'ops'
            val ops = Stack<Char>()

            var i = 0
            while (i < tokens.size) {
                // Current token is a whitespace, skip it
                if (tokens[i] == ' ') {
                    i++
                    continue
                }

                // Current token is a number, push it to stack for numbers
                if (tokens[i] in '0'..'9') {
                    val sBuf = StringBuffer()
                    // There may be more than one digits in number
                    while (i < tokens.size && tokens[i] in '0'..'9')
                        sBuf.append(tokens[i++])

                    if (i != tokens.size) {

                        // There may be a decimal
                        if (tokens[i] == '.') {
                            sBuf.append(".")
                            i++
                        }

                        while (i < tokens.size && tokens[i] in '0'..'9')
                            sBuf.append(tokens[i++])

                    }

                    values.push(sBuf.toString().toDouble())
                } else if (tokens[i] == '(')
                    ops.push(tokens[i])
                else if (tokens[i] == ')') {
                    while (ops.peek() !== '(')
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()))
                    ops.pop()
                } else if (tokens[i] == '+' || tokens[i] == '-' ||
                        tokens[i] == '*' || tokens[i] == '/') {

                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()))

                    // Push current token to 'ops'.
                    ops.push(tokens[i])
                }

                i++
            }

            while (!ops.empty())
                values.push(applyOp(ops.pop(), values.pop(), values.pop()))

            // Top of 'values' contains result, return it
            return values.pop()
        }

        private fun hasPrecedence(op1: Char, op2: Char): Boolean {
            return !((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
        }

        private fun applyOp(op: Char, b: Double, a: Double): Double {
            when (op) {
                '+' -> return a + b
                '-' -> return a - b
                '*' -> return a * b
                '/' -> {
                    if (b == 0.0)
                        throw UnsupportedOperationException("Cannot divide by zero")
                    return a / b
                }
            }
            return 0.0
        }
    }
}