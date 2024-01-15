package sorters

object HeapSorter: Sorter, Swapper {
    override fun sort(arr: Array<Int>, reverse: Boolean) {
        val n = arr.size
        for (i in (n / 2 - 1) downTo 0) heapify(arr, n, i, reverse)

        for (i in (n - 1) downTo 0) {
            swap(arr, 0, i)
            heapify(arr, i, 0, reverse)
        }
    }

    override fun compare(el1: Int, el2: Int, reverse: Boolean): Boolean {
        return if (reverse) el1 > el2 else el1 < el2
    }

    private fun heapify(arr: Array<Int>, n: Int, i: Int, reverse: Boolean) {
        var largest = i
        val l = 2 * i + 1
        val r = 2 * i + 2

        if (l < n && compare(arr[l], arr[largest], reverse)) largest = l
        if (r < n && compare(arr[r], arr[largest], reverse)) largest = r

        if (largest != i) {
            swap(arr, i, largest)
            heapify(arr, n, largest, reverse)
        }
    }


}