import java.util.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    var line = readLine()

    while (true) {
        if (line == "exit" || line.isNullOrBlank()) {
            exitProcess(0)
        } else {
            val expr = if (line != null) parseExpression(line) else break

            var i = 0;
            while (expr.size > 0) {
                if (isOperand(expr[i])) {
                    // TODO: finish
                } else {
                    // TODO: finish
                }
            }
        }

        line = readLine();
    }
}

fun parseExpression(expr: String) : ArrayList<String> {
    return ArrayList<String>(expr.split(" "))
}

fun isOperand(c: String) : Boolean {
    when(c) {
        "+", "-", "*", "/", "//", "!", "%", "^" -> return true
        else -> return false
    }
}