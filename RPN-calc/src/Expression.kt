class Expression(private val expr: String) {
    fun evaluate() : Number {
        val numStack = Stack<Number>()

        val symbols = expr.split(" ")

        for (symbol in symbols) {
            val opType = Operator.OpType.typeOf(symbol)

            if (opType == null) {
                numStack.push(Number(symbol))
            } else {
                when(opType) {
                    Operator.OpType.PLUS -> numStack.push(numStack.pop() + numStack.pop())
                    Operator.OpType.MINUS -> numStack.push(numStack.pop() - numStack.pop())
                    Operator.OpType.MULTIPLY -> numStack.push(numStack.pop() * numStack.pop())
                    Operator.OpType.DIVIDE -> numStack.push(numStack.pop() / numStack.pop())
                    Operator.OpType.MOD -> numStack.push(numStack.pop() % numStack.pop())
                }
            }
        }

        if (numStack.size() != 1) {
            return Number(0.0)
        } else {
            return numStack.pop()
        }
    }

    fun print() = expr

}