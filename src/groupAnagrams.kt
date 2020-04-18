import java.util.*
import kotlin.collections.HashMap

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    var elements = HashMap<String, ArrayList<String>>();
    for (str in strs) {
        val sortedCharArr = str.toCharArray()
        sortedCharArr.sort()
        val sortedStr = sortedCharArr.joinToString()
        var list = elements[sortedStr]
        if (list == null) {
            list = arrayListOf()
        }
        list.add(str)
        elements[sortedStr] = list
    }
    return elements.values.toList()
}

fun validateGroupAnagrams() {
    var test1 = arrayOf("eat","tea","tan","ate","nat","bat")
    var result = groupAnagrams(test1)
    for (r in result) {
        println(r)
    }
}