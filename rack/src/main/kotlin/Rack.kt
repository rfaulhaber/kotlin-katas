package rack

class Rack(val letters: String) {
    fun contains(word: String) : Boolean {
        val lettersCopy = Array(letters.length, Int::toString).toMutableList()

        for (c in word) {
            val s = c.toString()

            if (lettersCopy.contains(s)) {
                lettersCopy.removeAt(lettersCopy.indexOf(s))
            } else {
                return false
            }
        }

        return true
    }
}