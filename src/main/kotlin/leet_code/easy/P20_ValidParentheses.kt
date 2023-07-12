package leet_code.easy

import java.util.Stack

class P20_ValidParentheses {

    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false
        else {
            val stack = Stack<Char>()

            for (i in s.indices) {
                var isPossible = true

                when (val ch = s[i]) {
                    '(', '{','[' -> stack.push(ch)
                    ')' -> {
                        if (stack.isNotEmpty() && stack.peek() == '(') stack.pop()
                        else isPossible = false
                    }
                    '}' -> {
                        if (stack.isNotEmpty() && stack.peek() == '{') stack.pop()
                        else isPossible = false
                    }
                    ']' -> {
                        if (stack.isNotEmpty() && stack.peek() == '[') stack.pop()
                        else isPossible = false
                    }
                }

                if (!isPossible) return false
            }

            return stack.isEmpty()
        }
    }
}

fun main() {
    P20_ValidParentheses().isValid("([}}])").also { println(it) }
}