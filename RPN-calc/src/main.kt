import java.util.*
import kotlin.system.exitProcess

class Stack<Any> {
    private var data = ArrayList<Any>()

    fun push(n: Any) {
        data.add(n)
    }

    fun pop() : Any {
       return data.removeAt(data.lastIndex)
    }

    fun size() : Int {
        return data.size
    }
}

class Expression(private var data : Stack<ExpressionItem>) {
}

class ExpressionItem(var item : String) {
}

fun main(args: Array<String>) {
    var line = readLine()

    while (true) {
        if (line == "exit" || line.isNullOrBlank()) {
            exitProcess(0)
        } else {
            val expr = if (line != null) parseExpression(line) else break

            var i = 0;
            var stack = Stack<Double>()
            while (stack.size() > 0) {
                val item = expr[i]
                if (isOperand(item)) {
                    if (item == "!") {
                        stack.push(factorial(stack.pop().toInt()).toDouble())
                    } else {
                        val eval = eval(stack.pop(), stack.pop(), item)
                        if (eval == null) {
                            stack.push(0.0)
                        } else {
                            stack.push(eval)
                        }
                    }
                } else {
                    stack.push(item.toDouble());
                }

                i++;
            }
        }

        line = readLine()
    }
}

fun parseExpression(expr: String): ArrayList<String> {
    return ArrayList<String>(expr.split(" "))
}

fun isOperand(c: String): Boolean {
    when (c) {
        "+", "-", "*", "/", "//", "!", "%", "^" -> return true
        else -> return false
    }
}

fun eval(a: Double, b: Double, o: String): Double? {
    when (o) {
        "+" -> return a + b
        "-" -> return a - b
        "*" -> return a * b
        "/" -> return a / b
        "%" -> return a % b
        "^" -> return Math.pow(a, b)
        else -> return null
    }
}

fun factorial(n: Int): Int {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        var product = 0
        var counter = n

        while (counter > 0) {
            product *= counter
            counter--
        }

        return product
    }
}