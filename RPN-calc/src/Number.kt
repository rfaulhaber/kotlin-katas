class Number(private val value: Double) {
    constructor(s: String) : this(s.toDouble())

    operator fun plus(number: Number) : Number {
        return Number(this.value + number.value)
    }

    operator fun minus(number: Number) : Number {
        return Number(this.value - number.value);
    }

    operator fun times(number: Number) : Number {
        return Number(this.value * number.value)
    }

    operator fun div(number: Number) : Number {
        return Number(this.value / number.value);
    }

    operator fun mod(number: Number) : Number {
        return Number(this.value % number.value);
    }

    override fun toString() : String {
        return value.toString()
    }

    fun toDouble() : Double {
        return value;
    }
}