import kotlin.collections.ArrayList

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun _levelOrder(
    root: TreeNode?,
    level: Int,
    list: ArrayList<ArrayList<Int>>
) {
    if (root == null) {
        return
    }

    var listLevel: ArrayList<Int>?

    if (list.size <= level) {
        listLevel = ArrayList()
        list.add(listLevel)
    } else {
        listLevel = list[level]
    }
    listLevel.add(root.`val`)
    _levelOrder(root.left, level + 1, list)
    _levelOrder(root.right, level + 1, list)
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val list: ArrayList<ArrayList<Int>> = arrayListOf()
    _levelOrder(root, 0, list)
    return list
}