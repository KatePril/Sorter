package sorters

object MergeSorter: Sort {
//object MergeSorter {
    override fun sort(arr: Array<Int>, reverse: Boolean) {
        sort(arr,0, arr.size - 1)
    }

    private fun merge(arr: Array<Int>, l: Int, m: Int, r: Int) {
        val n1: Int = m - l + 1
        val n2: Int = r - m

        var left_arr: Array<Int> = emptyArray()
        for (i in 0..<n1) {
            left_arr += arr[l + i]
        }
        var right_arr: Array<Int> = emptyArray()
        for (i in 0..<n2) {
            right_arr += arr[m + 1 + i]
        }

        var i: Int = 0
        var j: Int = 0

        var k: Int = l
        while (i < n1 && j < n2) {
            if (left_arr[i] <= right_arr[j]) {
                arr[k] = left_arr[i]
                i++
            }
            else {
                arr[k] = right_arr[j]
                j++
            }
            k++
        }

        while (i < n1) {
            arr[k] = left_arr[i]
            i++
            k++
        }

        while (j < n2) {
            arr[k] = right_arr[j]
            j++
            k++
        }
    }

    private fun sort(arr: Array<Int>, l: Int, r: Int) {
        if (l < r) {
            val m: Int = l + (r-l) / 2

            sort(arr, l, m)
            sort(arr, m + 1, r)

            merge(arr, l, m, r)
        }
    }

}