import java.util.*

class Stack<Any> {
    val data = ArrayList<Any>()

    fun push(value: Any) {
        data.add(value)
    }

    fun pop() : Any {
        return data.removeAt(data.lastIndex)
    }

    fun size() : Int {
        return data.size
    }

    fun isEmpty() : Boolean {
        return data.isEmpty()
    }
}