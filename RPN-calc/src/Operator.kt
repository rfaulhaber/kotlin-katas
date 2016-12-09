class Operator(val value: String) {
    val type  = OpType.typeOf(value)
    enum class OpType(val operator: String) {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        MOD("%");

        companion object {
            private val map = OpType.values().map { it.operator to OpType.valueOf(it.name) }.toMap()

            fun typeOf(operator: String) : OpType? {
                if (map.containsKey(operator)) {
                    return map[operator]
                } else {
                    return null
                }
            }
        }
    }
}