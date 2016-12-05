import com.sun.xml.internal.fastinfoset.util.StringArray
import sun.jvm.hotspot.debugger.cdbg.Sym
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

class Expression {
    val data = Stack<Symbol>()

    fun addSymbol(s: Symbol) {
        data.push(s)
    }
}

interface Symbol {
    val symbol : String
}

class Number(override val symbol: String) : Symbol {
    val value = symbol.toDouble()
}

class Operator(override val symbol: String) : Symbol {
    val opType = OpType.valueOf(symbol)

    enum class OpType(val operator: String) {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        EXP("^"),
        FACT("!");

        companion object {
            private val map = OpType.values().map { it.operator to OpType.valueOf(it.name) }.toMap()
            fun getType(operator: String) = map[operator]

            fun getOpStrings() : Array<String> {
                return Array<String>(OpType.values().size, { i -> OpType.values()[i].operator })
            }
        }
    }
}

object ExpressionParser {
    fun parseExpression(expr: String) : Expression {
        val exprArr = expr.split(" ")

        val expression = Expression()

        val operators = Operator.OpType.getOpStrings()
        for (c in exprArr) {
            if (operators.contains(c)) {
                expression.addSymbol(Operator(c))
            } else {
                expression.addSymbol(Number(c))
            }
        }

        return expression
    }
}

fun main(args: Array<String>) {
    
}