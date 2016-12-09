fun main(args: Array<String>) {
    var expr = readLine()

    while (expr != "exit") {
        if (expr == null) continue

        println(Expression(expr).evaluate().toString())

        expr = readLine()
    }
}