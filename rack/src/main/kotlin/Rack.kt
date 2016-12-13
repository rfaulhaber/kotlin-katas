package rack

class Rack(val letters: String) {
    private val wildCard = "?"

    fun contains(word: String): Boolean {
        val lettersCopy = Array(letters.length, { i -> letters[i].toString() }).toMutableList()

        for (c in word) {
            val s = c.toString()

            if (lettersCopy.contains(s)) {
                lettersCopy.removeAt(lettersCopy.indexOf(s))
            } else if (lettersCopy.contains(wildCard)) {
                lettersCopy.removeAt(lettersCopy.indexOf(wildCard))
            } else {
                return false
            }
        }

        return true
    }

    fun findLongest(): String {
        val wordArrays = WordIndex.index.values

        var longest = ""

        for (array in wordArrays) {
            array
                    .asSequence()
                    .filter { this.contains(it) && it.length > longest.length }
                    .forEach { longest = it }
        }

        return longest;
    }
}