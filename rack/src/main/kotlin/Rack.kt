package rack

import java.util.*

class Rack(val letters: String) {
    fun contains(word: String) : Boolean {
        val lettersCopy = Array(letters.length, { i -> letters[i].toString()}).toMutableList()

        for (c in word) {
            val s = c.toString()

            if (lettersCopy.contains(s)) {
                lettersCopy.removeAt(lettersCopy.indexOf(s))
            } else if (lettersCopy.contains("?")) {
                lettersCopy.removeAt(lettersCopy.indexOf("?"))
            } else {
                return false;
            }
        }

        return true
    }

//    fun findLongest(word: String) : String {
//
//    }
}