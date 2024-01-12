package sorters

object QuickSorter: Sorter {
    override fun sort(arr: Array<Int>, reverse: Boolean) {
        sort(arr, 0, arr.size-1, reverse)
    }
    private fun partition(arr: Array<Int>, begin: Int, end: Int, reverse: Boolean): Int {
        val pivot = arr[end]
        var i = begin - 1

        for (j in begin..<end) {
            if (compare(arr[j], pivot, reverse)) {
                i++

                swap(arr, i, j)
            }
        }

        swap(arr, i+1, end)

        return i+1
    }

    private fun swap(arr: Array<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    private fun sort(arr: Array<Int>, begin: Int, end: Int, reverse: Boolean) {
        if (begin < end) {
            val partitionIndex = partition(arr, begin, end, reverse)

            sort(arr, begin, partitionIndex-1, reverse)
            sort(arr, partitionIndex+1, end, reverse)
        }
    }




}