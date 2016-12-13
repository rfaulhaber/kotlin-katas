package rack

import java.io.File
import java.util.*

object WordIndex {
    val index = indexWords()

    private fun getKey(str: String) : String {
        return str.substring(0, 3);
    }

    private fun indexWords() : HashMap<String, ArrayList<String>> {
        val wordMap = HashMap<String, ArrayList<String>>()
        File("data/words.txt").forEachLine {
            if (it.length < 3) {
                if (wordMap.containsKey(it)) {
                    wordMap[it]?.add(it)
                } else {
                    wordMap.put(it, ArrayList<String>())
                    wordMap[it]?.add(it)
                }
            } else {
                val key = it.substring(0, 3)

                if (wordMap.containsKey(key)) {
                    wordMap[key]?.add(it)
                } else {
                    wordMap.put(key, ArrayList<String>())
                    wordMap[key]?.add(it)
                }
            }
        }

        return wordMap;
    }
}
