package medium

import java.util.*

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.



Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 2

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */

fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<String>()
    tokens.forEach { token ->
        if(token.isOperator())
        {
            // in case if the toke is operator [+ - * /]
            // then pop last two element in the stack and calculate the result
            // then push the result in the stack
            val op2 = stack.pop().toInt()
            val op1 = stack.pop().toInt()
            val result = calculate(op1,op2,token)
            stack.push("$result")
        }else
            stack.push(token)
    }

    return stack.peek().toInt()
}

fun String.isOperator() = this == "+" || this  == "-" || this == "*" || this == "/"

fun calculate(op1:Int,op2: Int,token :String) :Int {
    return when(token)
    {
        "+" -> op1 +op2
        "-" -> op1 - op2
        "*" -> op1 * op2
        else -> op1 /op2
    }
}
