
fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
    var sums = HashMap<Int, Int>()

    for (a in A) {
        for (b in B) {
            var sum = a + b
            if (sums.containsKey(sum)) {
                sums[sum] = sums[sum]!! + 1
            } else {
                sums[sum] = 1
            }
        }
    }

    var count = 0

    for (c in C) {
        for (d in D) {
            var sum = (c + d) * -1
            if (sums.containsKey(sum)) {
                count += sums[sum]!!
            }
        }
    }

    return count
}


